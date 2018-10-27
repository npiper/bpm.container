package com.piperit.bpm.service;

import org.junit.Before;
import org.junit.Test;

public class StockVisibilityServiceTest {
	
	StockVisibilityService svs;
	
	@Before
	public void setUp()
	{
		svs = new StockVisibilityService();
	}

	@Test
	public void testFloat() {
		int number = svs.calculateStock();
		org.junit.Assert.assertNotEquals("Catch 22?", 22, number);
	}

}
