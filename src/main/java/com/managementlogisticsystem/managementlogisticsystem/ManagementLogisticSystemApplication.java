package com.managementlogisticsystem.managementlogisticsystem;

import com.managementlogisticsystem.managementlogisticsystem.user.model.User;
import com.managementlogisticsystem.managementlogisticsystem.user.permission.Permission;
import com.managementlogisticsystem.managementlogisticsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ManagementLogisticSystemApplication implements CommandLineRunner{


	private final UserService userService;

	public ManagementLogisticSystemApplication(UserService userService) {
		this.userService = userService;
	}


	public static void main(String[] args) {

		SpringApplication.run(ManagementLogisticSystemApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
			userService.addUser(createDummyUser("Frodo",List.of(Permission.MODIFY, Permission.READ_ONLY)));
		userService.addUser(createDummyUser("Hektor",List.of(Permission.NONE)));
		userService.addUser(createDummyUser("Mario",List.of(Permission.MODIFY, Permission.READ_ONLY)));
		userService.addUser(createDummyUser("Luigi",List.of(Permission.MODIFY, Permission.READ_ONLY)));
	}



	public User createDummyUser(String name, List<Permission> permissions){
		return User.builder().name(name).password("password").permissions(permissions).locked(false).build();
	}



}
