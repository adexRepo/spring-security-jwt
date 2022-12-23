package io.getarrays.userservice.auth.model;

import lombok.Data;

@Data 
public class RoleToUserForm {
    
    private String username;
    private String roleName;

}
