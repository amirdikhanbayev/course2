package com.example.demo.handler;

import com.example.demo.model.User1;
import com.example.demo.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private User1Repository user1Repository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String username = authentication.getName();
        Optional<User1> user1 = user1Repository.findByUsername(username);
        String role = user1.get().getRole();
        if(role.equals("ADMIN")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new CustomAuthenticationToken(role, null, authorities);
        }
        else if(role.equals("TEACHER")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_TEACHER"));
            return new CustomAuthenticationToken(role, null, authorities);
        }
        else if(role.equals("STUDENT")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_STUDENT"));
            return new CustomAuthenticationToken(role, null, authorities);
        }
        else {
            throw new UsernameNotFoundException("Invalid username");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(CustomAuthenticationToken.class);
    }
}