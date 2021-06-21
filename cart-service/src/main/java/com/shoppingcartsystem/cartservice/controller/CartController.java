 package com.shoppingcartsystem.cartservice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingcartsystem.cartservice.model.Cart;
import com.shoppingcartsystem.cartservice.model.Items;
import com.shoppingcartsystem.cartservice.repository.CartRepository;
import com.shoppingcartsystem.cartservice.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
    @PostMapping("/additem")
    public ResponseEntity<?> addItemToCart(@RequestBody Items item,
                                           @RequestParam String cartId){
        try{

            Cart cart = cartService.findByCartId(cartId);

            if(cart!=null){
                List<Items> items = cart.getItems();
                items.add(item);
                cart.setItems(items);
                cart.setCartTotal(cart.getCartTotal() + item.getProduct().getPrice()*item.getQuantity());
            }else{
                List<Items> items = new ArrayList<>();
                items.add(item);

                cart = new Cart();
                cart.setCartId(cartId);
                cart.setItems(items);
                cart.setCartTotal(item.getProduct().getPrice()*item.getQuantity());
            }

            Cart updatedCart = cartService.addItemToCart(cart);

            return  new ResponseEntity<>(updatedCart,HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Cart By User Id

    @GetMapping("/getcart")
    public ResponseEntity<?> getCartByUserId(@RequestParam String cartId){
        try{
            Cart cart = this.cartService.findByCartId(cartId);
            if(cart != null){
                return new ResponseEntity<>(cart,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Cart is empty",HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update Item in Cart

    @PutMapping("/updateitem")
    public ResponseEntity<?> updateItemInCart(@RequestBody Items item,
                                              @RequestParam String cartId){
        try{

            Cart cart = cartService.findByCartId(cartId);
            List<Items> items = cart.getItems();

            Items previousItem = new Items();



            for (Items value : items) {
                if (value.getProduct().getProductId().equals(item.getProduct().getProductId())) {

                    previousItem.getProduct().setProductId(value.getProduct().getProductId());
                    previousItem.getProduct().setPrice(value.getProduct().getPrice());
                    previousItem.setQuantity(value.getQuantity());

                    value.getProduct().setPrice(item.getProduct().getPrice());
                    value.setQuantity(item.getQuantity());
                    break;

                }
            }

            cart.setItems(items);

            double price = cart.getCartTotal()
                    - (previousItem.getProduct().getPrice()*previousItem.getQuantity())
                    + (item.getProduct().getPrice()*item.getQuantity());

            cart.setCartTotal(price);
            Cart updatedCart  = cartService.updateCart(cart);

            return  new ResponseEntity<>(updatedCart,HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete Item from Cart

    @DeleteMapping("/deleteitem")
    public ResponseEntity<?> deleteItemFromCart(@RequestBody Items item,
                                                @RequestParam String cartId
                                                ){
        try{
            Cart cart = this.cartService.findByCartId(cartId);
            List<Items> items = cart.getItems();

//          items.removeIf(x->x.getProductId().equals(productId));


            items.remove(item);
            cart.setItems(items);
            cart.setCartTotal(cart.getCartTotal()-item.getProduct().getPrice()*item.getQuantity());

            Cart cartAfterDeleted = this.cartService.deleteItemFromCart(cart);

            return new ResponseEntity<>(cartAfterDeleted,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
   
    

    @DeleteMapping("/deletecart")
    public ResponseEntity<?> deleteCart(@RequestParam String cartId){
        try{
            Cart cart = this.cartService.findByCartId(cartId);
            cart.setCartTotal(0);
            List<Items> items = new ArrayList<>();
            cart.setItems(items);
            cartService.updateCart(cart);
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
	