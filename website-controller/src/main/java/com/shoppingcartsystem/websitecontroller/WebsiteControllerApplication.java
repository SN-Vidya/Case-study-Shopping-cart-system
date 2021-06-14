package com.shoppingcartsystem.websitecontroller;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.shoppingcartsystem.websitecontroller.controller"})
//@EnableEurekaClient
@EnableSwagger2
public class WebsiteControllerApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public  Docket swaggerConfiguration()  {
            return new Docket(DocumentationType.SWAGGER_2)  
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.shoppingcartsystem.websitecontroller.controller"))
                .paths(PathSelectors.any())                          
                .build()
                .apiInfo(apiDetails());
	}
    private ApiInfo apiDetails() {
	        return  new ApiInfo("UserController Api",
			"Api Collections",
			null,
			null,
			new springfox.documentation.service.Contact(null, null, null),
			null,null,Collections.emptyList());
    }
			
	public static void main(String[] args) {
		SpringApplication.run(WebsiteControllerApplication.class, args);
	}

}


