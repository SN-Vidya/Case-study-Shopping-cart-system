package com.shoppingcartsystem.orderservice.service;

import java.util.List;
import com.shoppingcartsystem.orderservice.model.Order;


public interface OrderService {
	 
	void  addOrder(Order order);
    List<Order> findByOrderId(String orderId);

}