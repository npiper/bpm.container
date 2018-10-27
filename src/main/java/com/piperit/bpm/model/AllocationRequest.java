package com.piperit.bpm.model;

public class AllocationRequest {

	private String id;
	private ProductAllocation product;
	private Location sourceLocation;
	private Location targetLocation;
	
	
	enum AllocationMethod
	{
		FULL_PUSH, OPTIMAL
	}
	
	
    public String toJSONString() {
        return String.format("AllocationRequest{id=%s}", id);
    }
	
}
