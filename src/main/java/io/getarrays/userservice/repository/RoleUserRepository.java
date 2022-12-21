package io.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.userservice.domain.RoleUser;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{

    RoleUser findByName(String name);

}
