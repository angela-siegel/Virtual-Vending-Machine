package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Product {
	private String type;
	private String consumeMessage;
	
	public Beverage(String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Beverage";
		consumeMessage = "Glug Glug, Yum!";
	}

	public String getType() {
		return type;
	}

	public String getConsumeMessage() {
		return consumeMessage;
	}
}
