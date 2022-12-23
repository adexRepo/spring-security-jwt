package io.getarrays.userservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.userservice.auth.domain.UserBase;

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase,Long>{
    
    UserBase findByUsername(String userName);
}
