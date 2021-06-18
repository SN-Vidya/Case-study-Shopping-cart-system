package com.shoppingcartsystem.orderservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.orderservice.model.Cart;
import com.shoppingcartsystem.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	 

	List<Order> findOrderByCustomerId(Integer customerId);

	Optional<Order> findByOrderId(String orderId);

	Object save(Cart cart);

	
	
	
}
