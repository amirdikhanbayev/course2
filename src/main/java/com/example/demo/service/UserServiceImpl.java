package com.example.demo.service;

import com.example.demo.model.User1;
import com.example.demo.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User1Repository user1Repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User1 create(User1 user1){
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));
        return user1Repository.save(user1);
    }
    @Override
    public void delete(Long id){
         user1Repository.deleteById(id);
    }
    @Override
    public List<User1> findAll(){
        return user1Repository.findAll();
    }
    @Override
    public Optional<User1> findByUsername(String username){
        return user1Repository.findByUsername(username);
    }

    @Override
    public Optional<User1> findById(Long id){
        return user1Repository.findById(id);
    }

    @Override
    public User1 save(User1 user1){
        User1 old = user1Repository.findById(user1.getId()).orElse(new User1());
        old.setId(user1.getId());
        Optional.ofNullable(user1.getUsername()).ifPresent(old::setUsername);
        Optional.ofNullable(user1.getRole()).ifPresent(old::setRole);
        Optional.ofNullable(user1.getPassword()).ifPresent(old::setPassword);
        return user1Repository.save(old);
    }
    @Override
    public User1 getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return user1Repository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

}
