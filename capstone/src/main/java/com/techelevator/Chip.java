package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product implements Consumables{

	private String type;
	private String consumeMessage;
	
	public Chip (String slot, String name, BigDecimal price) {

		super(slot, name, price);
	}

	public String getType() {
		return "Chip";
	}

	public String getConsumeMessage() {
		return "Crunch Crunch, Yum!";
	}
	
}
