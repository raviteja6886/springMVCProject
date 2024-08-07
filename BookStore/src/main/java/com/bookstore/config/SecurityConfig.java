package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	static PasswordEncoder getPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
					.formLogin(Customizer.withDefaults())
					.logout(Customizer.withDefaults());

		return http.build();

	}

	@Bean
	UserDetailsService getUserDetailsService() {

		UserDetails admin = User.builder()
								.username("Ravi")
								.password(getPasswordEncoder()
								.encode("Ravi@123"))
								.roles("ADMIN").build();

		UserDetails user = User.builder()
								.username("mahesh")
								.password(getPasswordEncoder()
								.encode("mahesh@116"))
								.roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin, user);

	}

}
