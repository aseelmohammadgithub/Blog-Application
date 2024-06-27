package com.starsteam.blog;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.starsteam.blog.config.AppConstants;
import com.starsteam.blog.entities.Role;
import com.starsteam.blog.repositories.RoleRepo;

@SpringBootApplication
/*
 * @SpringBootApplication: This is a Spring Boot annotation that indicates this
 * class is the main entry point for the Spring Boot application. public class
 * BlogAppApisApplication implements CommandLineRunner: This defines a public
 * class named BlogAppApisApplication which implements the CommandLineRunner
 * interface. This interface has a single method, run, which will be executed
 * after the application context is loaded.
 */
public class BlogAppApisApplication implements CommandLineRunner {

	/*
	 * @Autowired: This annotation tells Spring to automatically inject the
	 * dependencies. Here, passwordEncoder and roleRepo are being injected.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}

	@Bean
	/*
	 * @Bean: This annotation tells Spring that this method returns a bean that
	 * should be managed by the Spring container. A bean is an object that Spring
	 * creates and manages for you. Beans help you organize your code and make it
	 * easier to use important objects everywhere they're needed. public ModelMapper
	 * modelMapper(): This method returns a new instance of ModelMapper, which is
	 * used to map objects from one type to another.
	 * Dependency injection means Spring automatically gives your code the objects it needs.
	 */
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	/*
	 * @Override: This annotation indicates that this method is overriding a method
	 * in the CommandLineRunner interface. public void run(String... args) throws
	 * Exception: This method is executed after the application starts.
	 */
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("xyz"));

		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

/*
 * package com.starsteam.blog;: This defines the package for the class, grouping
 * related classes together. The import statements bring in various classes and
 * interfaces from different libraries that the code needs to function.
 * 
 * try: This block attempts to execute the code inside it, and if an exception
 * occurs, it will be caught in the catch block. Role role = new Role();: This
 * creates a new instance of the Role class.
 * role.setId(AppConstants.ADMIN_USER);: This sets the ID of the role using a
 * constant defined in AppConstants. role.setName("ROLE_ADMIN");: This sets the
 * name of the role. Similarly, another role (role1) is created and configured.
 * List<Role> roles = List.of(role, role1);: This creates a list containing the
 * two roles. List<Role> result = this.roleRepo.saveAll(roles);: This saves all
 * the roles to the repository and returns the saved roles. result.forEach(r ->
 * { System.out.println(r.getName()); });: This iterates over the saved roles
 * and prints their names. Summary The BlogAppApisApplication class is the main
 * entry point for a Spring Boot application. It defines beans and injects
 * dependencies using Spring's annotations. The run method is executed after the
 * application starts, where it encodes a password, creates roles, saves them to
 * the repository, and prints their names.
 * 
 * 
 */