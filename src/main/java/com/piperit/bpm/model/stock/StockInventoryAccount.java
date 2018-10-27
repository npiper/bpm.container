package com.piperit.bpm.model.stock;

// Should each product line be like an account?
public class StockInventoryAccount {
	
	// Assumption has a parent Depot
	// A stock movement can be an intra-depot move via state change or to another Location
	
	// /stock/{locationID}/product_units/{productID}/
	
	enum StockStates
	{
		LOCKED,ALLOCATABLE,ALLOCATED
	}

}
