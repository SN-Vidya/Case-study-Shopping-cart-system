package com.shoppingcartsystem.orderservice.model;

import java.math.BigDecimal;

public class Items {
	private String productName;
	private BigDecimal price;
	private int quantity;
		
	public Items() {
		super();
	}
	public Items(String productName, BigDecimal price, int quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Items [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
