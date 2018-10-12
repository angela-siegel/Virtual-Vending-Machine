package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product implements Consumables{
	
	private String type;
	private String consumeMessage;
	
	public Gum (String slot, String name, BigDecimal price) {

		super(slot, name, price);

		type = "Gum";
		consumeMessage = "Chew Chew, Yum!";
	}

	public String getType() {
		return type;
	}

	@Override
	public String getConsumeMessage() {
		return consumeMessage;
	}
}
