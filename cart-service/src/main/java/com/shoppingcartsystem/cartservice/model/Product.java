package com.shoppingcartsystem.cartservice.model;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="Product")
public class Product {
	
	@Id
	private String productId;
	
	private String productName;
	
	private double price;
	
	
	public Product() {
		
	}
	
	

	public Product(String productId, String productName, double price) {
		super();
		this.productId = productId;
		
		this.productName = productName;
		
		this.price = price;
		
	}



	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}



	
	
	

}
