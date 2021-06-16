package com.shoppingcartsystem.websitecontroller.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import com.shoppingcartsystem.websitecontroller.repository.CartRepository;
import com.shoppingcartsystem.websitecontroller.repository.OrderRepository;
import com.shoppingcartsystem.websitecontroller.repository.ProductRepository;
import com.shoppingcartsystem.websitecontroller.repository.UserRepository;
//import com.shoppingcartsystem.websitecontroller.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	 private RestTemplate restTemplate;
	
	@Autowired
	private ProductRepository productRepository ;
	
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	//gives particular product
	 @RequestMapping(value="/findAllProducts/{productName}",method = RequestMethod.GET)
	 public List<Product> getAllProducts(@PathVariable("productName") String productName) {

	 restTemplate.getForObject("http://localhost:8082/product/findAllProducts/" + productName ,Product[].class);			
			return productRepository.findByProductName(productName);
		}
	 
	 //gives all products
	 @RequestMapping(value="/allproducts", method = RequestMethod.GET)
	 public Product[] getProduct() {

	 ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:8082/product/allproducts" ,Product[].class);
	
	 return response.getBody();
	        }
	 
	 @RequestMapping(value="/Category/{category}",method = RequestMethod.GET)
	 public List<Product> getProductsByCategory(@PathVariable("category") String category) {

	 restTemplate.getForObject("http://localhost:8082/product/Category/" + category ,Product[].class);			
			return productRepository.findByCategory(category);
		}
	 
	 @RequestMapping(value="/users/{_id}",method = RequestMethod.GET)
	 public Optional<User> getById(@PathVariable("_id") String _id) {

	 restTemplate.getForObject("http://localhost:8081/profile/users/" + _id ,User.class);			
			return userRepository.findById(_id);
		}
	 
	 
	 @RequestMapping(value="/userName/{fullName}", method = RequestMethod.GET)
	 public User getByFullNmae(@PathVariable("fullName") String fullName) {

	 restTemplate.getForObject("http://localhost:8081/profile/userName/" + fullName ,User.class);			
			return userRepository.findByFullName(fullName);
		}

     @RequestMapping(value = "/customerRegistration",method = RequestMethod.POST)
     public String addNewProfile(@RequestBody  User user)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(user,headers);
         return restTemplate.exchange("http://localhost:8081/profile/customerRegistration", HttpMethod.POST, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/delete/{_id}",method = RequestMethod.DELETE)
     public String deleteById(@PathVariable("_id") String _id)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(headers);
         return restTemplate.exchange("http://localhost:8081/profile/delete/"+ _id, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/update/{email_id}",method = RequestMethod.PUT)
     public String updateProfile(@PathVariable("email_id") String email_id, @RequestBody User user)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(user,headers);
         return restTemplate.exchange("http://localhost:8081/profile/update/"+ email_id, HttpMethod.PUT, entity, String.class).getBody();

     }
     
     @RequestMapping(value="/allcart/{cartId}",method = RequestMethod.GET)
	 public Cart getByCartId(@PathVariable("cartId") int cartId) {

	 restTemplate.getForObject("http://localhost:8083/CartService/allcart/" + cartId ,Cart.class);			
			return cartRepository.findByCartId(cartId);
		}
     
     @RequestMapping(value = "/addCart",method = RequestMethod.POST)
     public String addCart(@RequestBody Cart cart)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Cart> entity = new  HttpEntity<Cart>(cart,headers);
         return restTemplate.exchange("http://localhost:8083/CartService/addCart", HttpMethod.POST, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/deletecart/{_id}",method = RequestMethod.DELETE)
     public String deleteCartById(@PathVariable("_id") String _id)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Cart> entity = new  HttpEntity<Cart>(headers);
         return restTemplate.exchange("http://localhost:8083/CartService/deletecart/"+ _id, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
     @RequestMapping(value = "/updatecart/{cartId}",method = RequestMethod.PUT)
     public String updateCart(@PathVariable("cartId") int cartId, @RequestBody Cart cart)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Cart> entity = new  HttpEntity<Cart>(cart,headers);
         return restTemplate.exchange("http://localhost:8083/CartService/updatecart/"+ cartId, HttpMethod.PUT, entity, String.class).getBody();

     }
     
     @RequestMapping(value="/customerorder/{customerId}",method = RequestMethod.GET)
	 public List<Order> getOrderByCustomerId(@PathVariable("customerId") Integer customerId) {

	 restTemplate.getForObject("http://localhost:8084/order-service/customerorder/" + customerId ,Order[].class);			
			return orderRepository.findOrderByCustomerId(customerId);
		}
     
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

