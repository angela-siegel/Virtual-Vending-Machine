package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Product implements Consumables {
	private String type;
	private static String consumeMessage;
	
	public Beverage(String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Beverage";
		consumeMessage = "Glug Glug, Yum!";
	}

	public String getType() {
		return type;
	}

	public static String getConsumeMessage() {
		return consumeMessage;
	}
}
