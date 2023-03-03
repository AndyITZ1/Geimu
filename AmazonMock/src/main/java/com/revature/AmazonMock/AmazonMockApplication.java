package com.revature.AmazonMock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.revature.repositories")
@ComponentScan(basePackages = "com.revature")
@EntityScan("com.revature")
public class AmazonMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonMockApplication.class, args);
	}

}
