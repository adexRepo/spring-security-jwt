package io.getarrays.userservice.domain;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class UserBase {
    
    private Long id;
    private String name;
    private String username;
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleUser> roles = new ArrayList<RoleUser>();

}
