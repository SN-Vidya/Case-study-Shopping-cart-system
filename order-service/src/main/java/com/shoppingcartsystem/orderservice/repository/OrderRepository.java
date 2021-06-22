package com.shoppingcartsystem.orderservice.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.shoppingcartsystem.orderservice.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	 
	List<Order>findByOrderId(String orderId);
	
	
}
