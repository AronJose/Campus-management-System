package com.Campus.Campus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.Campus.Campus.entity.User;

public interface UserRepository extends Repository<User, Integer> {

    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findByUserIdAndPassword(Integer userId, String password);

    List<User> findAll();

    // list role 1
    @Query(value = "SELECT * FROM campus.user WHERE role=2", nativeQuery = true)
    List<User> findAllrole();

    @Query(value = "SELECT * FROM campus.user WHERE role=3", nativeQuery = true)
    List<User> findAllByrole();

    Optional<User> findByUserId(Integer userId);

    void delete(User orElseThrow);
}
