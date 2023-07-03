package com.example.demo.service;

import com.example.demo.model.User1;
import org.springframework.context.annotation.Bean;

public interface GetService {
    User1 getCurrentUser();
}
