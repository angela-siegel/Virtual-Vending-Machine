package com.techelevator;

import java.math.BigDecimal;

public class Candies extends Product {
	
	private String type;
	private String consumeMessage;
	
	public Candies (String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Candy";
		consumeMessage = "Munch Munch, Yum!";
	}

	public String getType() {
		return type;
	}

	public String getConsumeMessage() {
		return consumeMessage;
	}	
}