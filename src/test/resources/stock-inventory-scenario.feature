Feature: Load initial Stock Inventory

  Scenario: Day 0 - initial ISM load
  
   Given the following Product Lines and values
   | Champagne 750ml | 12 | LOCKED(DAMAGED) | 
   | Champagne 750ml | 33 | ALLOCATED | 
   | Champagne 750ml | 122 | UNALLOCATED | 
   AND I receive the following updates via a stock movement ITL
   | Champagne 750ml | 17 | LOCK(NEW VINTAGE) |
   AND the transaction if for Depot(BRADFORD)
   When I execute the update
   Then the stock position should reflect
   | Champagne 750ml | 12 | LOCKED(DAMAGED) |
   | Champagne 750ml | 17 | LOCKED(NEW VINTAGE) |
   | Champagne 750ml | 33 | ALLOCATED | 
   | Champagne 750ml | 105 | UNALLOCATED | 
   
  Scenario: Putaway initial stock

  Scenario: Request to Head office - Allocate from locked stock
 
  Scenario: Lock Stock (Code)
  
  Scenario: Red-Alert product at Depot
  
  Scenario: Pick Lock product at Depot
 
  Scenario: Unlock stock
 
  Scenario: Allocate Stock
  
  Scenario: Kit build an order
  
  Scenario: Unkit back to previous product(s)
  
  Scenario: Partially allocate stock
  
  Scenario: Stock item does not exist
  
  Scenario: De-allocate Stock
  
  Scenario: Dispatch stock
  
  Scenario: Load new ISM next day when values already exist
  
  Scenario: Stock movement paused during ISM load
  
  Scenario: Determine available stock to allocate
  