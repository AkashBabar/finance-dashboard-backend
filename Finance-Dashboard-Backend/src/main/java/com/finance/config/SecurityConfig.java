package com.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
			auth.requestMatchers("/users/**").hasRole("ADMIN");
			auth.requestMatchers("/records/**").hasAnyRole("ADMIN", "ANALYST");
			auth.requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST", "VIEWER");
			auth.anyRequest().authenticated();
		}).httpBasic(httpBasic -> {
		});

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {

		UserDetails admin = User.builder().username("admin").password(encoder.encode("admin123")).roles("ADMIN")
				.build();

		UserDetails analyst = User.builder().username("analyst").password(encoder.encode("analyst123")).roles("ANALYST")
				.build();

		UserDetails viewer = User.builder().username("viewer").password(encoder.encode("viewer123")).roles("VIEWER")
				.build();

		return new InMemoryUserDetailsManager(admin, analyst, viewer);
	}
}