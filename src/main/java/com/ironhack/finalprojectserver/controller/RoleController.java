package com.ironhack.finalprojectserver.controller;


import com.ironhack.finalprojectserver.DTO.RoleToUserDTO;
import com.ironhack.finalprojectserver.model.Role;
import com.ironhack.finalprojectserver.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @PostMapping("/roles/addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        userService.addRoleToUser(roleToUserDTO.getEmail(), roleToUserDTO.getRoleName());
    }


}
