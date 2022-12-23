package io.getarrays.userservice.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarrays.userservice.auth.domain.RoleUser;
import io.getarrays.userservice.auth.repository.UserBaseRepository;
import io.getarrays.userservice.auth.domain.UserBase;
import io.getarrays.userservice.auth.repository.RoleUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {

    private final UserBaseRepository userRepo;
    private final RoleUserRepository roleRepo;

    @Override
    public UserBase saveUser(UserBase user) {
        log.info("Saving new User: {}",user.getName());
        return userRepo.save(user);
    }
    
    @Override
    public RoleUser saveRole(RoleUser role) {
        log.info("Saving new Role: {}",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public UserBase getUser(String username) {
        log.info("Fetching User: {}" , username);
        return userRepo.findByUsername(username);
    }
    
    @Override
    public List<UserBase> getUsers() {
        log.info("Fetching all Users");
        return userRepo.findAll();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding Role: {} to User: {}" , roleName, username);
        UserBase user = userRepo.findByUsername(username);
        RoleUser role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    
}
