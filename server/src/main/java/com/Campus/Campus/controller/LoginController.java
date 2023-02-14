package com.Campus.Campus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Campus.Campus.form.LoginForm;
import com.Campus.Campus.service.UserService;
import com.Campus.Campus.view.LoginView;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public LoginView login(@Valid @RequestBody LoginForm form, Errors errors) {
        return userService.login(form, errors);
    }

    @PutMapping
    public LoginView refresh(@RequestBody String refreshToken) {
        return userService.refresh(refreshToken);
    }
}