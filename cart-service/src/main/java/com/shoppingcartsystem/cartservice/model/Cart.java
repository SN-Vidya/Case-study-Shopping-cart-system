package com.shoppingcartsystem.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cart")
public class Cart {
	@Id
	private String _id;
	
	private int cartId;
	private double totalPrice;
	private Items items;
	
	public Cart() {}

	public Cart(String _id, int cartId, double totalPrice, Items items) {
		super();
		this._id = _id;
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.items = items;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	
}
