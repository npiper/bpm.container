package com.piperit.bpm.service;

import org.springframework.stereotype.Component;

@Component
public class BackupAllocationService {
	
	public void execute(){
	   try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
