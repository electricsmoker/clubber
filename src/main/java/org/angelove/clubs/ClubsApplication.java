package org.angelove.clubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.angelove.clubs.repository"})
public class ClubsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubsApplication.class, args);
	}

}
