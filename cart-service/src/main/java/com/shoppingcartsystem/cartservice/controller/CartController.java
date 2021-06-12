package com.shoppingcartsystem.cartservice.controller;


  import java.util.List; 
  
  import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.PathVariable; 
  import org.springframework.web.bind.annotation.PostMapping; 
  import org.springframework.web.bind.annotation.PutMapping; 
  import org.springframework.web.bind.annotation.RequestBody; 
  import org.springframework.web.bind.annotation.RequestMapping; 
  //import org.springframework.web.bind.annotation.ResponseStatus; 
  import org.springframework.web.bind.annotation.RestController;
  
  import com.shoppingcartsystem.cartservice.model.Cart; 
  import com.shoppingcartsystem.cartservice.repository.CartRepository;
  
  
  @RestController
  
  @RequestMapping("/CartService")
  public class CartController{
  
  @Autowired
  private CartRepository cartRepository;
  
  @GetMapping("/allcarts") 
  public List<Cart> getAllCart() {
  
  return cartRepository.findAll(); }
  
  
  @GetMapping("/allcart/{_id}") 
  public Cart getByCartId( @PathVariable int cartId) {
  
  return cartRepository.findByCartId(cartId); }
  
  
  @PutMapping("/update/{_id}") 
  public Cart updateCart(@RequestBody Cart cart, @PathVariable String _id) {
 cart.set_id(_id);
  cartRepository.save(cart); return cart; }
  
  @PostMapping("/addCart") 
  public String addCart(@RequestBody Cart cart) {
  cartRepository.save(cart);
  return "A new Cart is added"; }
  
/*
 * @DeleteMapping("/deletecart/{_id}") public String deleteById(@PathVariable
 * String _id) {
 * 
 * cartRepository.deleteById(_id); return "Product Deleted with a Product Id " +
 * _id; }
 */
  
  
  
  
  }
  
 