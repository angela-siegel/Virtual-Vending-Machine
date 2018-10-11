package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {
	
	private String type;
	private String consumeMessage;
	
	public Gum (String name, BigDecimal price) {

		super(name, price);

		type = "Gum";
		consumeMessage = "Chew Chew, Yum!";
	}

	public String getType() {
		return type;
	}

	public String getConsumeMessage() {
		return consumeMessage;
	}
}
