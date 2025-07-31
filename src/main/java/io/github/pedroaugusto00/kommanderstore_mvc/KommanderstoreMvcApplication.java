package io.github.pedroaugusto00.kommanderstore_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KommanderstoreMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(KommanderstoreMvcApplication.class, args);
	}

}
