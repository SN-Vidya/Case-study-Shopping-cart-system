package com.shoppingcartsystem.productservice.repository;



import java.util.List;

//import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcartsystem.productservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByProductName(String productName);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByProductType(String productType);

	Product deleteByProductName(String productName); 
}
