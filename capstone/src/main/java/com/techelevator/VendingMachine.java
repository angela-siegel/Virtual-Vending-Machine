package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	Product p;
	BigDecimal runningBalance = new BigDecimal("0");
	ArrayList<String> purchaseList = new ArrayList<String>();

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
		return;
	}

	public Map<String, Product> getInventory() {

		return inventory;
	}

	public String purchase(String selection) {

		String response = "";
		if (inventory.containsKey(selection)) {

			p = inventory.get(selection);
			if (p.getQuantity() > 0) {
				if (p.getPrice().compareTo(runningBalance) <= 0) {// have the product, have enough money
					p.dispense();
					response = "Here is your " + p.getName() + ". Enjoy!";
					purchaseList.add(p.getName() + "|" + p.getQuantity());
					runningBalance = runningBalance.subtract(p.getPrice());
					// System.out.println(runningBalance.toString());
				} else {
					response = "Product cost more than current balance. Please feed more money";
				}

			} else {
				response = "SOLD OUT!";
			}

		} else {
			response = "Item does not exist. Please choose again.";
		}
		return response;

	}

	public BigDecimal feedMoney(BigDecimal money) {

		runningBalance = runningBalance.add(money);

		return runningBalance;
	}

	public String makeChange() {

		BigDecimal totalChange = runningBalance;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;

		while (runningBalance.compareTo(new BigDecimal("0.25")) >= 0) {
			runningBalance = runningBalance.subtract(new BigDecimal("0.25"));
			quarters++;
		}
		while (runningBalance.compareTo(new BigDecimal("0.10")) >= 0) {
			runningBalance = runningBalance.subtract(new BigDecimal("0.10"));
			dimes++;
		}
		while (runningBalance.compareTo(new BigDecimal("0.05")) >= 0) {
			runningBalance = runningBalance.subtract(new BigDecimal("0.05"));
			nickels++;
		}

		return "Your total change is: $" + totalChange.toString() + ". \n" + quarters + " quarters, " + dimes
				+ " dimes, " + nickels + " nickels.\n" + "Current Balance: $" + runningBalance;

	}

	public String getconsumeMessage() {

		String result = "";
		
		for(String selection : purchaseList) {

		if (selection.startsWith("A")) {
			result = result + ((Chip) p).getConsumeMessage() + "\n";
		}
		if (p.getSlot().startsWith("B")) {
			result = result + ((Candies) p).getConsumeMessage() + "\n";
		}
		if (p.getSlot().startsWith("C")) {
			result = result + ((Beverage) p).getConsumeMessage() + "\n";
		}
		if (p.getSlot().startsWith("D")) {
			result = result + ((Gum) p).getConsumeMessage() + "\n";
		}
	}
		return result;
	}
}
