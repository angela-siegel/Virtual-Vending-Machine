package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BeverageTest {
	private Beverage sut;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		
		sut = new Beverage ("C3", "Mountain Melter", new BigDecimal("1.50"));
		String result = sut.getConsumeMessage();
		assertEquals("Result should return Glug, Glug!", "Glug Glug, Yum!", result);
	}

}
