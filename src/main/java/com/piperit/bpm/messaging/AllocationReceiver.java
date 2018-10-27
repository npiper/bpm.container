package com.piperit.bpm.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.piperit.bpm.model.AllocationRequest;
import com.piperit.bpmcontainer.ProcessService;

@Component
public class AllocationReceiver {
	
	
	@Autowired
	private ProcessService myService;
	
	 @JmsListener(destination = "allocation_topic", containerFactory = "myFactory")
	    public void receiveMessage(AllocationRequest request) {
	        System.out.println("Received <" + request + ">");
	        
	        // Convert the message into starting a process
	        myService.startAllocationProcess(request, "assignee");
	        
	        
	        
	    }

}
