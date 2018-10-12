package com.techelevator;

import java.math.BigDecimal;

public class Product {

	private String name;
	private String slot;
	private BigDecimal price;
	private int quantity;
	
	public Product(String slot, String name, BigDecimal price) {
		
		this.name = name;
		this.price = price;
		this.slot = slot;
		quantity = 5;
	}
	
	public void dispense() {
		quantity--;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String getSlot() {
		return slot;
	}

}
