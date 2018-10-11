package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{

	private String type;
	private String consumeMessage;
	
	public Chip (String name, BigDecimal price) {

		super(name, price);

		type = "Chip";
		consumeMessage = "Crunch Crunch, Yum!";
	}

	public String getType() {
		return type;
	}

	public String getConsumeMessage() {
		return consumeMessage;
	}
	
}
