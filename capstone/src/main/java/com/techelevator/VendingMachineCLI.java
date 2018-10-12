package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private VendingMachine vM = new VendingMachine();
	Scanner in = new Scanner(System.in);


	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSATION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT,
			PURCHASE_MENU_OPTION_FINISH_TRANSATION };


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

						System.out.println(
								p.getSlot() + ") " + p.getName() + ": " + p.getQuantity() + " " + p.getPrice());
					}

				} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
					boolean shouldLoopPurchase = true;
					
					while(shouldLoopPurchase) {
						
						String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						
						if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
							
							while (true) {
								
								System.out.println("Please enter an amount to feed ($1, $2, $5, $10, $20):");				
								String input = in.nextLine();
								BigDecimal money = new BigDecimal(input);
								
								System.out.println("Balance is: $" + vM.feedMoney(money));
								System.out.println("Do you want to add more money(Y or N)?");
								String answer = in.nextLine();
								if (answer.toLowerCase().equals("n")) {
									break;
								}
								}
						} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
							while (true) {
								System.out.println("Please select a product by slot: ");
								String input = in.nextLine();
								String selection = new String(input);
								
								System.out.println("You chose: " + selection);
								
								System.out.println(vM.purchase(selection));
								
								System.out.println("Do you want to make another selection(Y or N)?");
								String answer = in.nextLine();
								if (answer.toLowerCase().equals("n")) {
									break;
								}
								}
							
						} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSATION)) {
							
							shouldLoop = false;
					}  
					} 
					
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
