package io.getarrays.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.getarrays.userservice.auth.domain.RoleUser;
import io.getarrays.userservice.auth.domain.UserBase;
import io.getarrays.userservice.auth.service.UserService;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new RoleUser(null,"ROLE_USER"));
			userService.saveRole(new RoleUser(null,"ROLE_MANAGER"));
			userService.saveRole(new RoleUser(null,"ROLE_ADMIN"));
			userService.saveRole(new RoleUser(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserBase(null,"Adx Krist","adx","rahasia1", new ArrayList<RoleUser>()));
			userService.saveUser(new UserBase(null,"Dupin Krist","dupin","rahasia1", new ArrayList<RoleUser>()));
			userService.saveUser(new UserBase(null,"Adec Krist","adec","rahasia1", new ArrayList<RoleUser>()));
			userService.saveUser(new UserBase(null,"Adek Krist","adek","rahasia1", new ArrayList<RoleUser>()));

			userService.addRoleToUser("adx", "ROLE_USER");
			userService.addRoleToUser("adec", "ROLE_ADMIN");
			userService.addRoleToUser("dupin", "ROLE_MANAGER");
			userService.addRoleToUser("adek", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("adek", "ROLE_ADMIN");
			userService.addRoleToUser("adek", "ROLE_USER");
		};
	}

}
