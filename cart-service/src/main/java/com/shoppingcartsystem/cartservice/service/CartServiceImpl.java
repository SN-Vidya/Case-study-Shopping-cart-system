package com.shoppingcartsystem.cartservice.service;

 import org.springframework.beans.factory.annotation.Autowired;
  
  import com.shoppingcartsystem.cartservice.model.Cart; 
  import com.shoppingcartsystem.cartservice.repository.CartRepository;
  
  import org.springframework.stereotype.Service;


	  @Service
	  public class CartServiceImpl implements CartService {
	  	
	  	@Autowired
	  	 CartRepository cartRepository;

	  	   

	  	
	  	@Override
	  	public Cart findByCartId(String cartId) {
	  		
	  		return cartRepository.findByCartId(cartId);
	  	}

	  	@Override
	  	public Cart addItemToCart(Cart cart) {
	  		
	  		return cartRepository.save(cart);
	  	}

	  	@Override
	  	public Cart updateCart(Cart cart) {
	  		
	  		return cartRepository.save(cart);
	  	}

	  	@Override
	  	public Cart deleteItemFromCart(Cart cart) {
	  		
	  		return cartRepository.save(cart);
	  	}
	  }
	  	
	  	
	  	
 