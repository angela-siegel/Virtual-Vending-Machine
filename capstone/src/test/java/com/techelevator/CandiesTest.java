package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CandiesTest {
	private Candies sut;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		
		sut = new Candies ("B3", "Wonka Bar", new BigDecimal("1.50"));
		String result = sut.getConsumeMessage();
		assertEquals("Result should return Munch Munch, Yum!", "Munch Munch, Yum!", result);
	}

}
