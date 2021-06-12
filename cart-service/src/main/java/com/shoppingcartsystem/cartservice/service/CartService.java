package com.shoppingcartsystem.cartservice.service;

import java.util.List;

import com.shoppingcartsystem.cartservice.model.Cart;


public interface CartService {
	List<Cart> getAllCarts();

	Cart getByCartId(int cartId);

	Cart addCart(Cart cart);

	Cart updateCart(Cart cart);

	//void deleteCartById(String _id);
}
	
	
	
	

