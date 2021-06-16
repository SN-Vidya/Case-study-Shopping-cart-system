package com.shoppingcartsystem.orderservice.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.orderservice.model.Order;
import com.shoppingcartsystem.orderservice.repository.OrderRepository;

@RestController
@RequestMapping("/order-service")
public class OrderController{
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/allorders")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> getAllOrder() {
		
		return orderRepository.findAll();
	}
	@GetMapping("/orders/{orderId}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Order> getByOrderId( @PathVariable String orderId) {
		
		return orderRepository.findByOrderId(orderId);
	}

	
	  @GetMapping("/customerorder/{customerId}")
	  @ResponseStatus(HttpStatus.FOUND) 
	  public List<Order> getOrderByCustomerId(Integer customerId) {
	  
	  return orderRepository.findOrderByCustomerId(customerId); }
	 
	@PutMapping("/update/{orderId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Order updateOrder(@RequestBody Order order, @PathVariable String orderId) {
		
		order.setOrderId(orderId);
		orderRepository.save(order);
		return order;
	}
	@PostMapping("/addOrder")
	public String addOrder(@RequestBody Order order) {
		
		orderRepository.save(order);
		return "A new Customer is added";
	}
	
	@DeleteMapping("/deleteorder/{orderId}")
	public String deleteOrderById(@PathVariable String orderId) {
		
		orderRepository.deleteById(orderId);
		return "Order Deleted with an Id: " + orderId;
	}
	
	
//	@PutMapping("/changeStatus/{orderId} ")
//	public String changeStatus(@PathVariable String orderId) {
//		
//		  orderRepository.changeStatus(orderId);
//		return "Order Status is updated";
//	}
	

}

