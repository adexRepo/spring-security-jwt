package io.getarrays.userservice.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarrays.userservice.auth.domain.RoleUser;
import io.getarrays.userservice.auth.domain.UserBase;
import io.getarrays.userservice.auth.repository.RoleUserRepository;
import io.getarrays.userservice.auth.repository.UserBaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService,UserDetailsService {

    private final UserBaseRepository userRepo;
    private final RoleUserRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBase userNow = userRepo.findByUsername(username);

        if(userNow == null){
            log.error("User not Found in the database");
            throw new UsernameNotFoundException(username);
        }else {
            log.error("User Found in the database: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userNow.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        
        UserDetails newUser = new User(userNow.getUsername(), userNow.getPassword(), authorities);
        return newUser;
    }

    @Override
    public UserBase saveUser(UserBase user) {
        log.info("Saving new User: {}",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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