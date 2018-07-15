package com.dh.configsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dh.configsecurity.*")
public class ConfigSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigSecurityApplication.class, args);
	}
}
