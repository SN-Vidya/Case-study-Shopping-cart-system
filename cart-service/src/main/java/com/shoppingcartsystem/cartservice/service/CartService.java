package com.shoppingcartsystem.cartservice.service;

import com.shoppingcartsystem.cartservice.model.Cart;


public interface CartService {
	Cart findByCartId(String cartId);

    Cart addItemToCart(Cart cart);

    Cart updateCart(Cart cart);

    Cart deleteItemFromCart(Cart cart);
}
	
	
	
	

