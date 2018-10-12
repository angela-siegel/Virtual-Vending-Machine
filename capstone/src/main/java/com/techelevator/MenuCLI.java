package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class MenuCLI {
	// Class representing the menu to be used
	/**********************************************************************
	 * Define String constants for the menu option text/choices named constants are
	 * a good idea s they make the code easier to follow and use
	 *********************************************************************/

	private static final String MAIN_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MAIN_MENU_OPTION_FINISH_TRANSATION = "Finish Transaction";

	private VendingMachine vM = new VendingMachine();
	Scanner in = new Scanner(System.in);
	/**********************************************************************
	 * Define array of String constants representing the menu option text/choices to
	 * be displayed to the user.
	 **********************************************************************/

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_FEED_MONEY, MAIN_MENU_OPTION_SELECT_PRODUCT, 
			MAIN_MENU_OPTION_FINISH_TRANSATION};
	/**********************************************************************
	 * Define array of String constants representing the menu option text/choices to
	 * be displayed to the user.
	 * 
	 * Note: named constants need not be used, but may make use of the menu more
	 * difficult.
	 **********************************************************************/

	// private static final String[] INSTRUCTOR_OPTIONS = { "Frank", "Joe", "Josh", "Craig", "End Process" };

	private Menu menu; // Define an instance variable for Menu object
						// This will be set by ctor using menu passed in by user

	public MenuCLI(Menu menu) { // ctor to set menu object to be used for this instance
			this.menu = menu;
		}

	/**********************************************************************
	 * Main processing loop invoked from main()
	 **********************************************************************/

	public void run() {

		boolean shouldLoop = true; // Loop control variable

		while (shouldLoop) { // Loop while loop control variable is true
			/**********************************************************************
			 * Define a variable to hold user menu choice & display menu to get it
			 * 
			 * getChoiceFromOptions will:
			 * 
			 * 1. Display the elements of the menu option array passed to it 2. Ask the user
			 * to pick one 3. return the constant defined in the menu option array passed to
			 * it for the option the user picked
			 **********************************************************************/

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			/**********************************************************************
			 * Examine choice made and process accordingly
			 **********************************************************************/

			if (choice.equals(MAIN_MENU_OPTION_FEED_MONEY)) {
				
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
				
			} else if (choice.equals(MAIN_MENU_OPTION_SELECT_PRODUCT)) {
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
				
			} else if (choice.equals(MAIN_MENU_OPTION_FINISH_TRANSATION)) {
				
				shouldLoop = false;
			} 
				
		}
	}

	/**********************************************************************
	 * main() method invokes main processing method run()
	 **********************************************************************/

	public static void main() {
		Menu menu = new Menu(System.in, System.out); // Define Menu object with input and output files
		MenuCLI mainMenu = new MenuCLI(menu); // Define a MenuClI object to handle menus
		mainMenu.run(); // Process using MenuCLI control logic
	}
}
