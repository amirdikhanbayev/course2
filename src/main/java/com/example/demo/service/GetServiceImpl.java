package com.example.demo.service;

import com.example.demo.model.User1;
import com.example.demo.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetServiceImpl implements GetService{
    @Autowired
    private User1Repository user1Repository;
    @Override
    public User1 getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        return user1Repository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
