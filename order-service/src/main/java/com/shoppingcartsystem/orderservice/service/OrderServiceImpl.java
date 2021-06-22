package com.shoppingcartsystem.orderservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingcartsystem.orderservice.model.Order;
import com.shoppingcartsystem.orderservice.repository.OrderRepository;

@Service	
public class OrderServiceImpl implements OrderService {
		
		@Autowired
		private OrderRepository orderRepository;

		@Override
	    public void addOrder(Order order) {
	        this.orderRepository.save(order);
	    }

	    @Override
	    public List<Order> findByOrderId(String orderId) {
	        return this.orderRepository.findByOrderId(orderId);
	    }
}
