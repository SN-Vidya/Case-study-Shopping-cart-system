package com.shoppingcartsystem.websitecontroller.controller;

import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shoppingcartsystem.websitecontroller.model.Cart;
import com.shoppingcartsystem.websitecontroller.model.Order;
import com.shoppingcartsystem.websitecontroller.model.Product;
import com.shoppingcartsystem.websitecontroller.model.User;

@RestController
@RequestMapping("/web")
public class UserController {
	
	@Autowired
	 private RestTemplate restTemplate;
	
	
	//gives particular product
	
	 @RequestMapping(value = "/findAllProducts/{productName}",method = RequestMethod.GET)
	  public String getAllProducts(@PathVariable("productName") String productName)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Product> entity = new  HttpEntity<Product>(headers);
	         return restTemplate.exchange("http://localhost:8082/product/findAllProducts/"+ productName, HttpMethod.GET, entity, String.class).getBody();

	     }
	 
	 //gives all products
	 @RequestMapping(value="/allproducts", method = RequestMethod.GET)
	 public Product[] getProduct() {

	 ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:8082/product/allproducts" ,Product[].class);
	
	 return response.getBody();
	        }
	 
	 //gives products of particular category
	 @RequestMapping(value = "/Category/{category}",method = RequestMethod.GET)
	  public String getProductsbyCategory(@PathVariable("category") String category)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Product> entity = new  HttpEntity<Product>(headers);
	         return restTemplate.exchange("http://localhost:8082/product/Category/"+ category, HttpMethod.GET, entity, String.class).getBody();

	     }
	 
//	 @RequestMapping(value="/Category/{category}",method = RequestMethod.GET)
//	 public List<Product> getProductsByCategory(@PathVariable("category") String category) {
//
//	 restTemplate.getForObject("http://localhost:8082/product/Category/" + category ,Product[].class);			
//			return productRepository.findByCategory(category);
//		}
	 
	 
	 
//	 @RequestMapping(value="/users/{_id}",method = RequestMethod.GET)
//	 public Optional<User> getById(@PathVariable("_id") String _id) {
//
//	 restTemplate.getForObject("http://localhost:8081/user/users/" + _id ,User.class);			
//			return userRepository.findById(_id);
//		}
	 
	 
	 @RequestMapping(value = "/userName/{fullName}",method = RequestMethod.GET)
	  public String getByFullName(@PathVariable("fullName") String fullName)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<User> entity = new  HttpEntity<User>(headers);
	         return restTemplate.exchange("http://localhost:8081/user/userName/"+ fullName, HttpMethod.GET, entity, String.class).getBody();

	     }
	 
	 
//	 @RequestMapping(value="/userName/{fullName}", method = RequestMethod.GET)
//	 public User getByFullNmae(@PathVariable("fullName") String fullName) {
//
//	 restTemplate.getForObject("http://localhost:8081/user/userName/" + fullName ,User.class);			
//			return userRepository.findByFullName(fullName);
//		}

     @RequestMapping(value = "/Register",method = RequestMethod.POST)
     public String addNewProfile(@RequestBody  User user)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(user,headers);
         return restTemplate.exchange("http://localhost:8081/user/Register", HttpMethod.POST, entity, String.class).getBody();

     }
     
    
   
//     @RequestMapping(value="/allcart/{cartId}",method = RequestMethod.GET)
//	 public Cart getByCartId(@PathVariable("cartId") int cartId) {
//
//	 restTemplate.getForObject("http://localhost:8083/CartService/allcart/" + cartId ,Cart.class);			
//			return cartRepository.findByCartId(cartId);
//		}
     
     @RequestMapping(value = "/getcart/{cartId}",method = RequestMethod.GET)
	  public String getByCartId(@PathVariable("cartId") int cartId)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<Cart> entity = new  HttpEntity<Cart>(headers);
	         return restTemplate.exchange("http://localhost:8083/cart/getcart/"+ cartId, HttpMethod.GET, entity, String.class).getBody();

	     }
     
     @RequestMapping(value = "/additem",method = RequestMethod.POST)
     public String addCart(@RequestBody Cart cart)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Cart> entity = new  HttpEntity<Cart>(cart,headers);
         return restTemplate.exchange("http://localhost:8083/cart/additem", HttpMethod.POST, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/deletecart/{cartId}",method = RequestMethod.DELETE)
     public String deleteCartById(@PathVariable("cartId") String cartId)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Cart> entity = new  HttpEntity<Cart>(headers);
         return restTemplate.exchange("http://localhost:8083/CartService/deletecart/"+ cartId, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
//     @RequestMapping(value = "/updateitem/{cartId}",method = RequestMethod.PUT)
//     public String updateCart(@PathVariable("cartId") int cartId, @RequestBody Cart cart)
//     {
//         HttpHeaders headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//         HttpEntity<Cart> entity = new  HttpEntity<Cart>(cart,headers);
//         return restTemplate.exchange("http://localhost:8083/CartService/updatecart/"+ cartId, HttpMethod.PUT, entity, String.class).getBody();
//
//     }
     
//     @RequestMapping(value="/customerorder/{customerId}",method = RequestMethod.GET)
//	 public List<Order> getOrderByCustomerId(@PathVariable("customerId") Integer customerId) {
//
//	 restTemplate.getForObject("http://localhost:8084/order-service/customerorder/" + customerId ,Order[].class);			
//			return orderRepository.findOrderByCustomerId(customerId);
//		}
     
     @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
     public String addOrder(@RequestBody Order order)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Order> entity = new  HttpEntity<Order>(order,headers);
         return restTemplate.exchange("http://localhost:8084/order-service/addOrder", HttpMethod.POST, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/deleteorder/{orderId}",method = RequestMethod.DELETE)
     public String deleteOrderById(@PathVariable("orderId") String orderId)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Order> entity = new  HttpEntity<Order>(headers);
         return restTemplate.exchange("http://localhost:8084/order-service/deleteorder/"+ orderId, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
	 


	 }

