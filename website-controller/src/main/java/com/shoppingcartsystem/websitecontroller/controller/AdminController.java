package com.shoppingcartsystem.websitecontroller.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.shoppingcartsystem.websitecontroller.model.Product;
import com.shoppingcartsystem.websitecontroller.model.User;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	 private RestTemplate restTemplate;
	
	//Deleting the particular User 
	 @RequestMapping(value = "/delete/{_id}",method = RequestMethod.DELETE)
     public String deleteById(@PathVariable("_id") String _id)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(headers);
         return restTemplate.exchange("http://localhost:8081/user/delete/"+ _id, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
	 @RequestMapping(value = "/update/{email_id}",method = RequestMethod.PUT)
     public String updateProfile(@PathVariable("email_id") String email_id, @RequestBody User user)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<User> entity = new  HttpEntity<User>(user,headers);
         return restTemplate.exchange("http://localhost:8081/user/update/"+ email_id, HttpMethod.PUT, entity, String.class).getBody();

     }
     
	 @RequestMapping(value = "/users/{_id}",method = RequestMethod.GET)
	  public String getById(@PathVariable("_id") String _id)
	     {
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.APPLICATION_JSON);
	         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	         HttpEntity<User> entity = new  HttpEntity<User>(headers);
	         return restTemplate.exchange("http://localhost:8081/user/users/"+ _id, HttpMethod.GET, entity, String.class).getBody();

	     }
	 
	 // Admin can delete particular product
	 
     @RequestMapping(value = "/deleteproduct/{_id}",method = RequestMethod.DELETE)
     public String deleteProductById(@PathVariable("_id") String _id)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Product> entity = new  HttpEntity<Product>(headers);
         return restTemplate.exchange("http://localhost:8082/admins/deleteproduct/"+ _id, HttpMethod.DELETE, entity, String.class).getBody();

     }
     
     //Admin can add the product
     
     @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
     public String addProduct(@RequestBody  Product product)
     {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<Product> entity = new  HttpEntity<Product>(product,headers);
         return restTemplate.exchange("http://localhost:8082/admins/addProduct", HttpMethod.POST, entity, String.class).getBody();

     }
     

}
