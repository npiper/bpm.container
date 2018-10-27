package com.piperit.bpm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class GoodsReceipt {


    private String id;
    
	private Date receiptDate;
	private Location sendingParty;
	private Location receivingParty;
	private List<HandlingUnit> handlingUnits;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public Location getSendingParty() {
		return sendingParty;
	}
	public void setSendingParty(Location sendingParty) {
		this.sendingParty = sendingParty;
	}
	public Location getReceivingParty() {
		return receivingParty;
	}
	public void setReceivingParty(Location receivingParty) {
		this.receivingParty = receivingParty;
	}
	public List<HandlingUnit> getHandlingUnits() {
		return handlingUnits;
	}
	public void setHandlingUnits(List<HandlingUnit> handlingUnits) {
		this.handlingUnits = handlingUnits;
	}
}
