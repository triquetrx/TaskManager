package com.triquetrx.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration{

	@Bean
	public UserDetailsService createUser() {
		UserDetails user = User.builder()
				.username("zaid")
				.password("{bcrypt}$2a$10$C3lyks4J23BfmAuCbRAY1eojKdbDlpDbOQ0spgxx2ZZYgh62mJKle")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}
