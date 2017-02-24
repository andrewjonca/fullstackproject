package com.fullstack;

import com.fullstack.backend.persistence.domain.Role;
import com.fullstack.backend.persistence.domain.User;
import com.fullstack.backend.persistence.domain.UserRole;
import com.fullstack.backend.service.UserService;
import com.fullstack.enums.PlansEnum;
import com.fullstack.enums.RolesEnum;
import com.fullstack.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FullstackApplication implements CommandLineRunner {
	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(FullstackApplication.class);

	@Autowired
	private UserService userService;


	public static void main(String[] args) {

		SpringApplication.run(FullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String username = "proUser";
		String email = "proUser@gmail.com";

		User user = UserUtils.createBasicUser(username, email);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
		LOG.debug("Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO, userRoles);
		LOG.info("User {} created", user.getUsername());
	}
}
