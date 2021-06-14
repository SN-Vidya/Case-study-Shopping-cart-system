package com.shoppingcartsystem.websitecontroller.model;

public class Items {
	
	private String productName;
	private int quantity;
	private double price;
	//private Product product;
	
	public Items() {}

	public Items(String productName, int quantity, double price ) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		//this.product = product;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
	
		
	}
	