package com.shoppingcartsystem.profileservice;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSwagger2
//@EnableEurekaClient
public class ProfileServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
