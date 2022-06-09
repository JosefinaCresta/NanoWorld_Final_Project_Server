package com.ironhack.finalprojectserver.service.interfaces;


import com.ironhack.finalprojectserver.model.Role;
import com.ironhack.finalprojectserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();

    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
}
