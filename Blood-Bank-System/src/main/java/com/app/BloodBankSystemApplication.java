package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BloodBankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankSystemApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/login").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/api/bloodbank").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/api/user/{id}").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/api/user-update").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/getUser").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/isLogged").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/get-user-events").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/get-sports").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/get-event-types").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/get-all-features").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/event-players").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/player-add/{id}").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/add-team").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/event/{id}").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/add-playersFees/{value}").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("/get-user-sport").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
				registry.addMapping("").allowedOrigins("http://localhost:3000").allowCredentials(true);
			}
		};
	}

}
