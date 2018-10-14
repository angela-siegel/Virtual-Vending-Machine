package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private VendingMachine sut;
	@Before
	public void setUp() throws Exception {
		sut = new VendingMachine();
		sut.stockVendingMachine();
		sut.feedMoney(new BigDecimal("10"));
	}

	@Test
	public void testA4() {
		String result = sut.purchase("A4");
		assertEquals("Result should be: Here is your Cloud Popcorn. Enjoy!", "Here is your Cloud Popcorn. Enjoy!", result);
	}
	
	@Test
	public void testG9() {
		String result = sut.purchase("G9");
		assertEquals("Result should be: Item does not exist. Please choose again.", 
				"Item does not exist. Please choose again.", result);
	}

	@Test
	public void testSoldOut() {
		int x = 1;
		String result = "";
		
		while (x < 7) {
			x++;
			result = sut.purchase("A2");
		}
		
		assertEquals("Result should be: SOLD OUT!", 
				"SOLD OUT!", result);
	}
	
	@Test
	public void testFeed1() {
		BigDecimal result = sut.feedMoney(new BigDecimal("1"));
		assertEquals("Result should be: 11", new BigDecimal("11"), result);
	}
	
	@Test
	public void testFeed2() {
		BigDecimal result = sut.feedMoney(new BigDecimal("2"));
		assertEquals("Result should be: 12", new BigDecimal("12"), result);
	}
	
	@Test
	public void testFeed5() {
		BigDecimal result = sut.feedMoney(new BigDecimal("5"));
		assertEquals("Result should be: 15", new BigDecimal("15"), result);
	}
	
	@Test
	public void testFeed10() {
		BigDecimal result = sut.feedMoney(new BigDecimal("10"));
		assertEquals("Result should be: 20", new BigDecimal("20"), result);
	}
	
	@Test
	public void testFeed20() {
		BigDecimal result = sut.feedMoney(new BigDecimal("20"));
		assertEquals("Result should be: 30", new BigDecimal("30"), result);
	}
	
	@Test
	public void testMakeChange() {
		sut.purchase("B2");
		String result = sut.makeChange();
		
		assertEquals("Result should include all change by coin",
				"Your total change is: $8.50. " + "\n" + "34 quarters, 0 dimes, 0 nickels." + "\n" + "Current Balance: $0.00", 
				result);
	}
	
	@Test
	public void testGetConsumedMessage() {
		sut.purchase("B2");
		String result = sut.getconsumeMessage();
		
		assertEquals("Result should Munch Munch, Yum!", "Munch Munch, Yum!", result);
	}
	
}
