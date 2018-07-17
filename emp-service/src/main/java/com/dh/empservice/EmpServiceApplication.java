package com.dh.empservice;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.dh.empservice.*")
public class EmpServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	
}
