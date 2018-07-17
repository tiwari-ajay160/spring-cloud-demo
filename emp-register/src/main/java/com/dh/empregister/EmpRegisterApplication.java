package com.dh.empregister;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dh.empregister.*")
public class EmpRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpRegisterApplication.class, args);
		 ArrayList<String> a=new ArrayList<String>();
	}
 
	
	@Bean
	public BCryptPasswordEncoder passCodeEncryptor(){
		return new BCryptPasswordEncoder();
	}
}     
