package com.dilshan.login.Register;

import com.dilshan.login.Register.role.Role;
import com.dilshan.login.Register.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class LoginRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegisterApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(RoleRepository roleRepository){

		return args -> {
			if(roleRepository.findByName("USER").isEmpty()){
				roleRepository.save(
						Role.builder().name("USER").build()
				);
			}
		};
	}
}
