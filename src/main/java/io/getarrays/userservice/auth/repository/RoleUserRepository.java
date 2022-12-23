package io.getarrays.userservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.auth.domain.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{

    RoleUser findByName(String name);

}
