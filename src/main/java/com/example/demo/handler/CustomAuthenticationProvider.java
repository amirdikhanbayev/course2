package com.example.demo.handler;

import com.example.demo.model.User1;
import com.example.demo.repository.User1Repository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String username = authentication.getName();
        Optional<User1> user1 = userService.findByUsername(username);
        String role = user1.get().getRole();
        if(role.equals("ADMIN")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
            return new CustomAuthenticationToken(role, null, authorities);
        }
        else if(role.equals("TEACHER")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("TEACHER"));
            return new CustomAuthenticationToken(role, null, authorities);
        }
        else if(role.equals("STUDENT")){
            List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("STUDENT"));
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
