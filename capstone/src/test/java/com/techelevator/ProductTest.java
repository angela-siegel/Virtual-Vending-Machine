package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class ProductTest {

	private Product sut;
	@Before
	public void setUp() throws FileNotFoundException {

	}

	@Test
	public void testGetName() {
		
		sut = new Product ("A2", "Stackers", new BigDecimal("1.75"));
		String result = sut.getName();
		assertEquals("Result should return Stackers", "Stackers", result);
	}

	@Test
	public void testGetPrice() {
		
		sut = new Product ("A2", "Stackers", new BigDecimal("1.75"));
		BigDecimal result = sut.getPrice();
		assertEquals("Result should return Stackers", new BigDecimal("1.75"), result);
	}
	
	@Test
	public void testGetQuantity() {
		
		sut = new Product ("A2", "Stackers", new BigDecimal("1.75"));
		
		int result = sut.getQuantity();
		assertEquals("Result should return 5", 5, result);
	}
	
	@Test
	public void testGetSlot() {
		
		sut = new Product ("A2", "Stackers", new BigDecimal("1.75"));
		String result = sut.getSlot();
		assertEquals("Result should return A2", "A2", result);
	}
}
