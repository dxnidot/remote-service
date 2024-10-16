package com.example.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {
	
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi
				.builder()
				.group("api")
				.pathsToMatch("/**")
				.build();
	}

}
