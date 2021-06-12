package com.shoppingcartsystem.orderservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.shoppingcartsystem.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	 //Order deleteBy(String _id);

	List<Order> findOrderByCustomerId(int customerId);

	Optional<Order> findByOrderId(int orderId);

	//Order deleteOrderById(String _id);
	
}
