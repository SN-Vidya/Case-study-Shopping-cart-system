package com.shoppingcartsystem.websitecontroller.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {
	

	@Id
	private String  _id;
	
	private int productId;
	private String productType;
	private String productName;
	private String category;
	private Double price;
	private int rating;
	private String description;
	
public Product() {}


public Product(String _id, int productId, String productType, String productName, String category, Double price,
		int rating, String description) {
	super();
	this._id = _id;
	this.productId = productId;
	this.productType = productType;
	this.productName = productName;
	this.category = category;
	this.price = price;
	this.rating = rating;
	this.description = description;
}


public String get_id() {
	return _id;
}

public void set_id(String _id) {
	this._id = _id;
}

public int getProductId() {
	return productId;
}


public void setProductId(int productId) {
	this.productId = productId;
}

public String getProductType() {
	return productType;
}

public void setProductType(String productType) {
	this.productType = productType;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

@Override
public String toString() {
	return "Product [_id=" + _id + ", productId=" + productId + ", productType=" + productType + ", productName="
			+ productName + ", category=" + category + ", price=" + price + ", rating=" + rating + ", description="
			+ description + "]";
}

}


