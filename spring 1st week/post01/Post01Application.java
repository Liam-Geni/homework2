package com.sparta.post01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Post01Application {

	public static void main(String[] args) {

		SpringApplication.run(Post01Application.class, args);
	}

}
