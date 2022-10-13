package com.sparta.post02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Post02Application {

	public static void main(String[] args) {

		SpringApplication.run(Post02Application.class, args);
	}

}
