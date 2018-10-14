package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class GumTest {
	private Gum sut;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		
		sut = new Gum ("D1", "U-Chews", new BigDecimal("0.85"));
		String result = sut.getConsumeMessage();
		assertEquals("Result should return Chew Chew, Yum!", "Chew Chew, Yum!", result);
	}

}
