package com.shoppingcartsystem.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.productservice.model.Product;
import com.shoppingcartsystem.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/admins")
public class AdminController {
	@Autowired 
	private ProductRepository productRepository;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		productRepository.save(product);
		return "A new product is added";
	}
	@PutMapping("/updateproduct")
	public String updateProduct(Product product) {
		
		productRepository.save(product);
		return "A existing product is updated";
	}
	@PutMapping("/update/{_id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable String  _id) {
		
		product.set_id(_id);
		productRepository.save(product);
		return product;
	}
	@DeleteMapping("/deleteproduct/{_id}")
	public String deleteById(@PathVariable String _id) {
		
		productRepository.deleteById(_id);
		return "Product Deleted with a Product Id " + _id;
	}


}
