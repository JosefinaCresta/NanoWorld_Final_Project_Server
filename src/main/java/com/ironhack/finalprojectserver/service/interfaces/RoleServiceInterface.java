package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.model.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}
