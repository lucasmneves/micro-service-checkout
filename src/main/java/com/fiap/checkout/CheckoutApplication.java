package com.fiap.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fiap.checkout.infraestructure.persistence.repositories")
public class CheckoutApplication {
	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}
}
