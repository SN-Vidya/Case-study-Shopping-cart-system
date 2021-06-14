package com.shoppingcartsystem.websitecontroller.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.websitecontroller.model.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

	

	Cart findByCartId(int cartId);

	//Cart deleteCartById(String _id);

	

}
