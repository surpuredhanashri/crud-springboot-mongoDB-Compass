package com.example.springbootmongocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongocrud.entity.User;
import com.example.springbootmongocrud.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/{user_id}")
    public User updateUser(@RequestBody User user, @PathVariable("user_id") Long id) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{user_id}")
    public String deleteUser(@PathVariable("user_id") Long id) {
        userService.deleteUser(id);
        return "deleted succesfully.";
    }
}