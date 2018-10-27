package com.piperit.bpm.service;

import org.springframework.stereotype.Component;

@Component
public class StockVisibilityService {
	
	// Search for product lines at Depot
	//stock/{locationID}/product_units/ 
	
	// By ID
	// By ..
	
	// /stock/{locationID}/product_units/{productID}/
	
	// Actions:
	// Move (State To) OR
	// Lock
	// Unlock
	// Putaway
	// Dispatch
	// Unallocate
	// Allocate
	
	
	public int calculateStock()
	{
		double ratio = Math.random();
		Float f = new Float(ratio * 100);
		
		return f.intValue();
		
	}

}
