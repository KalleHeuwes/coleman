package de.kheuwes.coleman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("de.kheuwes.coleman.repos") 
@EntityScan("de.kheuwes.coleman.model")
@SpringBootApplication
public class ColemanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColemanApplication.class, args);
	}

}
