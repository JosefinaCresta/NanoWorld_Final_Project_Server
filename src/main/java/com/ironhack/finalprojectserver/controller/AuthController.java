package com.ironhack.finalprojectserver.controller;

import com.google.gson.Gson;
import com.ironhack.finalprojectserver.DTO.UserVerifyDTO;
import com.ironhack.finalprojectserver.DTO.UserWithRoleDTO;
import com.ironhack.finalprojectserver.model.User;
import com.ironhack.finalprojectserver.repository.UserRepository;
import com.ironhack.finalprojectserver.service.impl.UserService;
import com.ironhack.finalprojectserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userServiceInterface.saveUser(user);
    }

    @PostMapping("/signup/withRole")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUserWithRole(@RequestBody @Valid UserWithRoleDTO userSignupWithRole) {
        return userServiceInterface.saveUserWithRole(userSignupWithRole);
    }


    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getName(),
                userFromDb.getRole().getName());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }
}
