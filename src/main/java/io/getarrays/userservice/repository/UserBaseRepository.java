package io.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.getarrays.userservice.domain.UserBase;

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase,Long>{
    
    UserBase findByUsername(String userName);
}
