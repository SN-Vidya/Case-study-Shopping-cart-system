package com.shoppingcartsystem.productservice.service;

import java.util.List;

//import java.util.Optional;

import com.shoppingcartsystem.productservice.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();

	List<Product> getProductByName(String productName);

	List<Product> getProductByCategory(String category);

	List<Product> getProductByType(String productType);

	Product addProduct(Product product);

	Product updateProduct(Product product);

	Product deleteByProductName(String productName);
	
	//void deleteProduct(String _id);
}
