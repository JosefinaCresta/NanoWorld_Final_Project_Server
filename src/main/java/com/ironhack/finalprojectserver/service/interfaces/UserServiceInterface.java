package com.ironhack.finalprojectserver.service.interfaces;


import com.ironhack.finalprojectserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();
}
