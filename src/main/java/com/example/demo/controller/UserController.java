package com.example.demo.controller;

import com.example.demo.model.User1;
import com.example.demo.service.GetService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GetService getService;

    @GetMapping("/logout")
    public String logout(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "Logged out";
    }
    @PostMapping("/createUser")
    //done
    public User1 createUser(@RequestBody User1 user){
        return userService.create(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    //done
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
    @GetMapping("/listall")
    @PreAuthorize("hasAuthority('ADMIN')")
    //done
    public List<User1> listALl(){
        return userService.findAll();
    }
    @GetMapping("/findUser/{username}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    //done
    public Optional<User1> findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    @GetMapping("/findUserById/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    //done
    public Optional<User1> findByIdUser(@PathVariable Long id){
        return userService.findById(id);
    }
    @PutMapping("/ChangeUser")
    @PreAuthorize("hasAuthority('ADMIN')")
    //done
    public User1 changeUser(@RequestBody User1 user){
        return userService.save(user);
    }
    @GetMapping("/me")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER','STUDENT')")
    //done
    public User1 getMe (){
        return getService.getCurrentUser();
    }
}
