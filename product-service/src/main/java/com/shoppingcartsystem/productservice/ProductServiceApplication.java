package com.shoppingcartsystem.productservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
    public Docket swaggerApiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.shoppingcartsystem.productservice"))
                .build()
                .apiInfo(apiDetails());
    }
	private ApiInfo apiDetails() {
        return new ApiInfo("Product Service API",
                "Product details ",
                "1.0",
                "",
                new springfox.documentation.service.Contact("Vidya","www.product.com",""),
                "API License","",
                Collections.emptyList());
    }


}
