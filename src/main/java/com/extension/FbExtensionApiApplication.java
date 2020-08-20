package com.extension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.extension.repository.VerifyKeysRepository;

@EnableMongoRepositories(basePackageClasses = VerifyKeysRepository.class)
//disable auto configure security spring boot
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FbExtensionApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FbExtensionApiApplication.class, args);
	}
}