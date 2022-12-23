package io.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{
    
}
