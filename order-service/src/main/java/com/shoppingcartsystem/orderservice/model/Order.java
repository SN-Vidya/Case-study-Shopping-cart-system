package com.shoppingcartsystem.orderservice.model;

import java.math.BigDecimal;


//import java.time.LocalDate;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.time.LocalDate;

@Document(collection="orders")
public class Order {
	
	@Id
	private String orderId;
	private String orderDate;
	private Integer customerId;
	private String paymentMode;
	private BigDecimal amountPaid;
	private String orderStatus;
	private int quantity;
	private Address address;
	private Product product;
	
	public Order() {
		super();
	}

	public Order(String orderId, String orderDate, Integer customerId, String paymentMode, BigDecimal amountPaid,
			String orderStatus, int quantity, Address address, Product product) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.paymentMode = paymentMode;
		this.amountPaid = amountPaid;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.address = address;
		this.product = product;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", paymentMode=" + paymentMode + ", amountPaid=" + amountPaid + ", orderStatus=" + orderStatus
				+ ", quantity=" + quantity + ", address=" + address + ", product=" + product + "]";
	}
}
	
	
	