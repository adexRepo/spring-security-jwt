package io.getarrays.userservice.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncode {
    @Bean
    public BCryptPasswordEncoder byCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
