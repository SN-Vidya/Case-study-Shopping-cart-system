package com.shoppingcartsystem.orderservice.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cart")
public class Cart {
	
	@Id
	private String _id;
	
	private int cartId;
	private BigDecimal totalPrice;
	private List<Items> items;
	
	public Cart() {
		super();
	}
	public Cart(String _id, int cartId, BigDecimal totalPrice, List<Items> items) {
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
	public BigDecimal getTotalPrice() {
		
		for(int i=0; i<(items.size()); i++)
		{
			totalPrice=totalPrice.add(((Items) items).getPrice());
		}
		
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [_id=" + _id + ", cartId=" + cartId + ", totalPrice=" + totalPrice + ", items=" + items + "]";
	}
	
}

