package com.example.demo.service;

import com.example.demo.model.User1;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User1 create(User1 user1);

    void delete(Long id);

    List<User1> findAll();

    Optional<User1> findByUsername(String username);

    Optional<User1> findById(Long id);

    User1 save(User1 user1);

    User1 getCurrentUser();
}
