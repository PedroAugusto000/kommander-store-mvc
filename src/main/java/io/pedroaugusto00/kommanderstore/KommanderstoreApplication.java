package io.pedroaugusto00.kommanderstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.EntityListeners;

@SpringBootApplication
@EnableJpaAuditing
public class KommanderstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KommanderstoreApplication.class, args);
	}

}
