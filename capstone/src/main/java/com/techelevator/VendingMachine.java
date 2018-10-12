package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	BigDecimal runningBalance = new BigDecimal("0");

	private Map<String, Product> inventory = new HashMap<String, Product>();

	public void stockVendingMachine() throws FileNotFoundException {
		File input = new File("vendingMachine.csv");

		try (Scanner inputFile = new Scanner(input)) {
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				String[] items = line.split("\\|");

				if (items[0].startsWith("A")) {
					inventory.put(items[0], new Chip(items[0], items[1], new BigDecimal(items[2])));
				} else if (items[0].startsWith("B")) {

					inventory.put(items[0], new Candies(items[0], items[1], new BigDecimal(items[2])));
				} else if (items[0].startsWith("C")) {

					inventory.put(items[0], new Beverage(items[0], items[1], new BigDecimal(items[2])));
				} else if (items[0].startsWith("D")) {

					inventory.put(items[0], new Gum(items[0], items[1], new BigDecimal(items[2])));
				}
			}

		}
	}

	public Map<String, Product> getInventory() {

		return inventory;
	}

	public String purchase(String selection) {
		
		String response = "";
				
			if (!inventory.containsKey(selection)) {
					response = "Item does not exist. Please choose again.";
				}

			/*else if (s.getQuantity() > 0) {
				s.dispense();
				System.out.println(s.getQuantity());
				// makeChange(s.getPrice());

				if (s.getSlot().startsWith("A")) {
					response = ((Chip) s).getConsumeMessage();
				} else if (s.getSlot().startsWith("B")) {
					response = ((Candies) s).getConsumeMessage();
				}
				else if (s.getSlot().startsWith("C")) {
					response = ((Beverage) s).getConsumeMessage();
				} else if (s.getSlot().startsWith("D")) {
					response = ((Gum) s).getConsumeMessage();
				}
			} */
			else {
				response = "???";
			}
			return response;
		// }
		}

	public BigDecimal feedMoney(BigDecimal money) {

		runningBalance = runningBalance.add(money);

		return runningBalance;
	}

	public BigDecimal makeChange(BigDecimal cost) {
		runningBalance = runningBalance.subtract(cost);
		return runningBalance;

	}

}
