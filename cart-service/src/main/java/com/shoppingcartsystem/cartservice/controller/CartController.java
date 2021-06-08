package com.shoppingcartsystem.cartservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CartController{
	@GetMapping("/hellocart")
    public String test() {
	return "Hello Cart Service";	
	}
}
