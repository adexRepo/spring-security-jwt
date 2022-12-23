package io.getarrays.userservice.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.getarrays.userservice.auth.domain.UserBase;

public interface UserBaseRepository extends JpaRepository<UserBase,Long>{
    
    UserBase findByUsername(String userName);
}
