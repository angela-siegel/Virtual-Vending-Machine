package com.techelevator;

import java.math.BigDecimal;

public class Candies extends Product implements Consumables{
	
	private String type;
	private static String consumeMessage;
	
	public Candies (String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Candy";
		consumeMessage = "Munch Munch, Yum!";
	}

	public String getType() {
		return type;
	}

	public static String getConsumeMessage() {
		return consumeMessage;
	}	
}