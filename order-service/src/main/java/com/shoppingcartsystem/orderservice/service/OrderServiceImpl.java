package com.shoppingcartsystem.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingcartsystem.orderservice.model.Order;
import com.shoppingcartsystem.orderservice.repository.OrderRepository;



public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> getByOrderId(int orderId) {
		
		return orderRepository.findByOrderId(orderId);
	}

	 
	@Override
	public Order updateOrder(Order order) {
		
		return orderRepository.save(order);
	}
	
	
	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	/*
	 * @Override public Order deleteOrderById(String _id) { return
	 * orderRepository.deleteOrderById(_id); }
	 */
	@Override
	public List<Order> getOrderByCustomerId(int customerId) {
		return orderRepository.findOrderByCustomerId(customerId);
	}

	
	
}
