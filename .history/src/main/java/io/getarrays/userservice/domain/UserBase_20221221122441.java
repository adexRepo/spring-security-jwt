package io.getarrays.userservice.domain;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

public class UserBase {
    
    private Long id;
    private String name;
    private String username;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleUser> roles = new ArrayList<RoleUser>();

}
