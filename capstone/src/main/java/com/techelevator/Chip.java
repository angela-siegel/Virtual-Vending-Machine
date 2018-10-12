package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product implements Consumables{

	private String type;
	private static String consumeMessage;
	
	public Chip (String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Chip";
		consumeMessage = "Crunch Crunch, Yum!";
	}

	public String getType() {
		return type;
	}

	public static String getConsumeMessage() {
		return consumeMessage;
	}
	
}
