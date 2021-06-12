package com.shoppingcartsystem.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcartsystem.orderservice.model.Order;


public interface OrderService {
	 
	List<Order> getAllOrder();
	
	Order addOrder(Order order);
	
	Order updateOrder(Order order);
	
	//Order deleteOrderById(String _id);
	
	List<Order> getOrderByCustomerId(int customerId);

	Optional<Order> getByOrderId(int orderId);

}
