package com.example.demo.handler;

import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private void sharedSecurityConfiguration(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        sharedSecurityConfiguration(http);
        http.authorizeRequests()
                .requestMatchers("/task").hasRole("ADMIN", "TEACHER")
    }
}
