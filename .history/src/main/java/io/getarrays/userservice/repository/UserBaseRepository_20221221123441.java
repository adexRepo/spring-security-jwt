package io.getarrays.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.getarrays.userservice.domain.UserBase;

public interface UserBaseRepository extends JpaRepository<UserBase,Long>{
    
    Optional<UserBase> findByUsername(String userName);
}
