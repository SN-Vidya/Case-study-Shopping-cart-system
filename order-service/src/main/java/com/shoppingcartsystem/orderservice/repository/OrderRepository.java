package com.shoppingcartsystem.orderservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.orderservice.model.Cart;
import com.shoppingcartsystem.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	 //Order deleteBy(String _id);

	List<Order> findOrderByCustomerId(Integer customerId);

	Optional<Order> findByOrderId(String orderId);

	//Order deleteOrderById(String _id);
	
	//List<Order> findByCustomerId(Integer customerId);

	//String changeStatusTo(String orderStatus, String orderId);

	Object save(Cart cart);

	//void deleteOrderById(String orderId);

	//void changeStatus(String orderId);

	
	
	
}
