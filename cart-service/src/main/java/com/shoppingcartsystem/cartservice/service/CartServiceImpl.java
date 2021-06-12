package com.shoppingcartsystem.cartservice.service;

  import java.util.List; 
  
  import org.springframework.beans.factory.annotation.Autowired;
  
  import com.shoppingcartsystem.cartservice.model.Cart; 
  import com.shoppingcartsystem.cartservice.repository.CartRepository;
  
  public class CartServiceImpl implements CartService{
  
  @Autowired 
  private CartRepository cartRepository;
  
  @Override 
  public List<Cart> getAllCarts() {
  
  return cartRepository.findAll(); }
  
  @Override 
  public Cart getByCartId(int cartId) {
  
  return cartRepository.findByCartId(cartId); }
  
  
  @Override 
  public Cart updateCart(Cart cart) {
  
  return cartRepository.save(cart); }
  
  
  @Override public Cart addCart(Cart cart) { 
	  return cartRepository.save(cart);
  }
  
  
  
	/*
	 * @Override public Cart cartTotal(Double price) { return
	 * cartRepository.save(price); }
	 */
  
  }
 