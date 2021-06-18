package com.shoppingcartsystem.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcartsystem.orderservice.model.Cart;
import com.shoppingcartsystem.orderservice.model.Order;


public interface OrderService {
	 
	List<Order> getAllOrder();
	
	Order addOrder(Order order);
	
	Order updateOrder(Order order);
	

	Optional<Order> getByOrderId(String orderId);
	
	
	Object placeOrder(Cart cart);
	
	void deleteOrder(String orderId);
	
	List<Order> getOrderByCustomerId(Integer customerId);

	


}
