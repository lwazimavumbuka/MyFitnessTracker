package com.myproject.myfitnesstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.myproject.model")
@ComponentScan(basePackages = "com.myproject")
@EnableJpaRepositories(basePackages = "com.myproject.repository")
public class MyfitnesstrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfitnesstrackerApplication.class, args);
	}

}
