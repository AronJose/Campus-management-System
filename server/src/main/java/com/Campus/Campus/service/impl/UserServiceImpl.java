package com.Campus.Campus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Campus.Campus.view.LoginView;
import com.Campus.Campus.entity.User;
import com.Campus.Campus.exception.BadRequestException;
import com.Campus.Campus.exception.NotFoundException;
import com.Campus.Campus.form.LoginForm;
import com.Campus.Campus.form.UserForm;
import org.springframework.validation.Errors;
import org.springframework.web.server.ResponseStatusException;

import com.Campus.Campus.repository.UserRepository;
import com.Campus.Campus.security.config.SecurityConfig;
import com.Campus.Campus.security.util.InvalidTokenException;
import com.Campus.Campus.security.util.TokenExpiredException;
import com.Campus.Campus.security.util.TokenGenerator;
import com.Campus.Campus.security.util.TokenGenerator.Status;
import com.Campus.Campus.security.util.TokenGenerator.Token;
import com.Campus.Campus.service.UserService;
import com.Campus.Campus.view.UserView;

import static com.Campus.Campus.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenGenerator tokenGenerator;

    @Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        User user = userRepository.findByEmail(form.getEmail()).orElseThrow(UserServiceImpl::badRequestException);
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw badRequestException();
        }

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + user.getPassword(),
                securityConfig.getRefreshTokenExpiry());
        return new LoginView(user, accessToken, refreshToken);
    }

    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
        } catch (InvalidTokenException e) {
            throw new BadRequestException("Invalid token", e);
        } catch (TokenExpiredException e) {
            throw new BadRequestException("Token expired", e);
        }
        int userId;
        try {
            userId = Integer.parseInt(status.data.substring(0, 10));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid token", e);
        }

        String password = status.data.substring(10);

        User user = userRepository.findByUserIdAndPassword(userId, password)
                .orElseThrow(UserServiceImpl::badRequestException);

        String id = String.format("%010d", user.getUserId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                user,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry));
    }

    // AddUsers

    @Override
    public UserView add(UserForm form) {

        Optional<User> usernameEntry = userRepository.findByEmail(form.getEmail());
        if (usernameEntry.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }
        return new UserView(userRepository.save(new User(
                form.getSchoolId(),
                form.getFullName(),
                form.getEmail(),
                form.getPhone(),
                passwordEncoder.encode(form.getPassword()),
                form.getRole(),
                form.getStatus(),
                form.getAddress(),
                form.getDob()

        )));

    }

// List of Users
    @Override
    public List<UserView>list()
    {
        List<UserView>userViews = new ArrayList<>();
        List<User>users = userRepository.findAll();
        users.forEach(user ->{
            userViews.add(new UserView(user));
        });
        return userViews;
    }

    // list rol2 1
    @Override
    public List<UserView>list1()
    {
        List<UserView>userViews = new ArrayList<>();
        List<User>users = userRepository.findAllrole();
        users.forEach(user ->{
            userViews.add(new UserView(user));
        });
        return userViews;
    }

    @Override
    public List<UserView>list2()
    {
        List<UserView>userViews = new ArrayList<>();
        List<User>users = userRepository.findAllByrole();
        users.forEach(user ->{
            userViews.add(new UserView(user));
        });
        return userViews;
    }

    @Override
    public UserView get(Integer userId) throws NotFoundException{
        return userRepository.findByUserId(userId).map((user)->{
            return new UserView(user);
        }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public UserView update(Integer userId, UserForm form) throws NotFoundException {
        return userRepository.findByUserId(userId)
                .map((user) -> {

                    return new UserView(userRepository.save(user.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public void delete(Integer userId) throws NotFoundException {
        userRepository.delete(
            userRepository.findByUserId(userId)
                        .orElseThrow(NotFoundException::new)
        );
    }

    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }


}
