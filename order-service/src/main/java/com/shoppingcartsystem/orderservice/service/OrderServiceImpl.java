package com.shoppingcartsystem.orderservice.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//import static org.springframework.data.mongodb.core.query.Query.query;
//import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PutMapping;

import com.shoppingcartsystem.orderservice.model.Cart;
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
	public Optional<Order> getByOrderId(String orderId) {
		
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
	public List<Order> getOrderByCustomerId(Integer customerId) {
		return orderRepository.findOrderByCustomerId(customerId);
	}
	
	@Override
	public void deleteOrder(String orderId) {
		
		orderRepository.deleteById(orderId);
	}


	@PutMapping("/placeorder")
	public Object placeOrder(Cart cart) {
		
		return orderRepository.save(cart);
	}

//	@Override
//	public String changeStatus(String orderId) {
//		
//		  Order order1=mongoOperations.findOne(query(where("orderId").is(orderId)),Order.class); 
//		  mongoOperations.updateFirst(query(where("OrderId").is(3001)),
//		  Update.update("orderStatus", "Order Placed"), Order.class);
//		
//		return "Order Status is updated";
//	}
//
//	
	
}
