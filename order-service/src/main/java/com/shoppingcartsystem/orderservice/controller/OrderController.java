package com.shoppingcartsystem.orderservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class OrderController{
	@GetMapping("/helloorder")
  public String test() {
	return "Hello Order Service";	
	}
}
