package com.example.demo.controller;

import com.example.demo.model.User1;
import com.example.demo.service.GetService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/createUser")
    public User1 createUser(@RequestBody User1 user){
        return userService.create(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
    @GetMapping("/listall")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User1> listALl(){
        return userService.findAll();
    }
    @GetMapping("/findUser/{username}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public Optional<User1> findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    @GetMapping("/findUserById/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<User1> findByIdUser(@PathVariable Long id){
        return userService.findById(id);
    }
    @PutMapping("/ChangeUser")
    @PreAuthorize("hasRole('ADMIN')")
    public User1 changeUser(@RequestBody User1 user){
        return userService.save(user);
    }
    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public User1 getMe (){
        return getService.getCurrentUser();
    }
}
