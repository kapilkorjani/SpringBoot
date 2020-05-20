package com.lorrymgmtsyst.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lorrymgmtsyst.repository")
@ComponentScan(basePackages = {"com.lorrymgmtsyst"})
@EntityScan("com.lorrymgmtsyst.model")
public class LorryMangementSystemRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LorryMangementSystemRestApiApplication.class, args);
	}

}
