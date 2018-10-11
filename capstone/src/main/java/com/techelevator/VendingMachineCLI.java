package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private VendingMachine vM = new VendingMachine();

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		try {

			vM.stockVendingMachine();
			boolean shouldLoop = true;

			while (shouldLoop) {
				String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

				if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

					Map<String, Product> inventory = vM.getInventory();

					for (Map.Entry<String, Product> entry : inventory.entrySet()) {

						Product p = (Product) entry.getValue();

						System.out.println(p.getName() + ":\t\t" + p.getQuantity() + "\t\t" + p.getPrice());
					}

				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					// do purchase - good place for a method call
				} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
					// do any end of program processing - good place for a method call
					shouldLoop = false;
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Vending Machine Failed to Stock. File not found.");
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
