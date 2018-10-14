package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class ChipTest {
	private Chip sut;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		
		sut = new Chip ("A3", "Grain Waves", new BigDecimal("2.75"));
		String result = sut.getConsumeMessage();
		assertEquals("Result should return Crunch Crunch, Yum!", "Crunch Crunch, Yum!", result);
	}

}
