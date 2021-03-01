package com.innovision.needle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NeedleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedleApplication.class, args);
	}

}


