package com.shoppingcartsystem.paymentservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController{
	@GetMapping("/hellopayment")
    public String test() {
	return "Hello Payment Service";	
	}
	}
	
