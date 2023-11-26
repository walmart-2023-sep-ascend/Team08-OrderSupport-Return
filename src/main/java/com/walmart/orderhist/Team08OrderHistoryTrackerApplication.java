package com.walmart.orderhist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.walmart.orderhist.*")

public class Team08OrderHistoryTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team08OrderHistoryTrackerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
