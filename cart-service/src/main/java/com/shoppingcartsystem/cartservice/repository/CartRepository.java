package com.shoppingcartsystem.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.cartservice.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

	

	Cart findByCartId(String cartId);
	

}
