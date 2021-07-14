package com.loizenai.jwtauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;

import com.loizenai.jwtauthentication.services.FilesStorageService;


@SpringBootApplication
public class SpringBootJwtAuthenticationExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationExamplesApplication.class, args);
	}

}
