package io.getarrays.userservice.auth.api;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.getarrays.userservice.auth.domain.RoleUser;
import io.getarrays.userservice.auth.domain.UserBase;
import io.getarrays.userservice.auth.model.RoleToUserForm;
import io.getarrays.userservice.auth.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    /* -------------------------------------------------------------------------- */
    /*                                 GET METHOD                                 */
    /* -------------------------------------------------------------------------- */

    @GetMapping("/users")
    public ResponseEntity<List<UserBase>> getUser(){
        return ResponseEntity.ok().body(userService.getUsers());

    }

    /* -------------------------------------------------------------------------- */
    /*                                 POST METHOD                                */
    /* -------------------------------------------------------------------------- */

    @PostMapping("/user/save")
    public ResponseEntity<UserBase> saveUser(@RequestBody UserBase user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<RoleUser> saveRole(@RequestBody RoleUser roleUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(roleUser));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm formRoleToUser){
        userService.addRoleToUser(formRoleToUser.getUsername(),formRoleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }

}
