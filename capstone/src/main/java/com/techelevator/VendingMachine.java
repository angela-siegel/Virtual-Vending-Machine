package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

	Product p;
	BigDecimal runningBalance = new BigDecimal("0");
	List<String> purchaseList = new ArrayList<String>();
	String result = "";
	int numberSold;
	BigDecimal totalSales;
	List<String> log = new ArrayList<String>();
	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

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
					p.setNumberSold((numberSold += 1));

					Calendar cal = Calendar.getInstance();
					log.add(dateFormat.format(cal.getTime()) + " " + p.getName() + " " + p.getSlot() + " "
							+ runningBalance + " " + runningBalance.subtract(p.getPrice()));

					purchaseList.add(p.getName() + "|" + Integer.toString(p.getNumberSold()));

					runningBalance = runningBalance.subtract(p.getPrice());

					response = "Here is your " + p.getName() + ". Enjoy!";

					if (selection.toUpperCase().startsWith("A")) {
						result += ("\n" + ((Chip) p).getConsumeMessage());
					} else if (selection.toUpperCase().startsWith("B")) {
						result += ("\n" + ((Candies) p).getConsumeMessage());
					} else if (selection.toUpperCase().startsWith("C")) {
						result += ("\n" + ((Beverage) p).getConsumeMessage());
					} else if (selection.toUpperCase().startsWith("D")) {
						result += ("\n" + ((Gum) p).getConsumeMessage());
					}
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

		Calendar cal = Calendar.getInstance();
		log.add(dateFormat.format(cal.getTime()) + " Feed Money:" + money + " " + runningBalance);

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

		Calendar cal = Calendar.getInstance();
		log.add(dateFormat.format(cal.getTime()) + " Give Change:" + totalChange + " " + runningBalance);

		return "Your total change is: $" + totalChange.toString() + ". \n" + quarters + " quarters, " + dimes
				+ " dimes, " + nickels + " nickels.\n" + "Current Balance: $" + runningBalance;

	}

	public String getconsumeMessage() {

		return result;
	}

	public void logToFile() throws FileNotFoundException {

		File logFile = new File("/Users/evanbelfiore/workspace/java-module-1-capstone-team-1", "Log.txt"); // ,
		try (PrintWriter writer = new PrintWriter(logFile)) {

				for (int i = 0; i < log.size(); i++) {

					String str = log.get(i);
					writer.println(str);
				}
		} catch (Exception ex) {
			System.out.println("Error 404: File Not Found");
		}
	}
}