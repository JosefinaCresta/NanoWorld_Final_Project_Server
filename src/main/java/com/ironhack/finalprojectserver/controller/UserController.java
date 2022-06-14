package com.ironhack.finalprojectserver.controller;


import com.ironhack.finalprojectserver.DTO.UserWithRoleDTO;
import com.ironhack.finalprojectserver.model.User;
import com.ironhack.finalprojectserver.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers(){
        return userServiceInterface.getUsers();
    }

   /* @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }*/

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user) {
        userServiceInterface.saveUser(user);
    }

    @PostMapping("/users/withRole")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUserWithRole(@RequestBody UserWithRoleDTO userSignupWithRole) {
        userServiceInterface.saveUserWithRole(userSignupWithRole);
    }
}
