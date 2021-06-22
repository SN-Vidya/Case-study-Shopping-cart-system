package com.shoppingcartsystem.paymentservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
@Bean 
	
	public Docket swaggerConfiguratin() { return new
			  Docket(DocumentationType.SWAGGER_2) .select()
			  		.apis(RequestHandlerSelectors.basePackage("com.shoppingcartsystem.productservice"))
			  		.build(); }



}
