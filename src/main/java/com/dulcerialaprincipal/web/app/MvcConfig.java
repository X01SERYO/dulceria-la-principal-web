package com.dulcerialaprincipal.web.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MvcConfig {

	@Bean
	public BCryptPasswordEncoder contraseñaCodificada() {
		return new BCryptPasswordEncoder();
	}
}
