package com.shoppingcartsystem.websitecontroller.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.websitecontroller.model.Cart;
import com.shoppingcartsystem.websitecontroller.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	 //Order deleteBy(String _id);

	List<Order> findOrderByCustomerId(Integer customerId);

	Optional<Order> findByOrderId(String orderId);

	//Order deleteOrderById(String _id);
	
	//List<Order> findByCustomerId(Integer customerId);

	//String changeStatusTo(String orderStatus, String orderId);

	Object save(Cart cart);

	//void changeStatus(String orderId);

	
	
	
}
