package io.getarrays.userservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.userservice.auth.domain.RoleUser;


@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser,Long>{

    RoleUser findByName(String name);

}
