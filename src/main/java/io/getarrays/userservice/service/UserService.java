package io.getarrays.userservice.service;

import java.util.List;

import io.getarrays.userservice.domain.RoleUser;
import io.getarrays.userservice.domain.UserBase;

public interface UserService {
    
    UserBase saveUser(UserBase user);
    RoleUser saveRole(RoleUser role);
    UserBase getUser (String username);
    List<UserBase> getUsers();

    void addRoleToUser(String username, String role);
}
