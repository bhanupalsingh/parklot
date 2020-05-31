package com.park.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
//	private int id;
	private int noOfSLot ;
	private static AtomicInteger ID = new AtomicInteger();
	private List<Slot> slotsList;
	
	
	public ParkingLot(int slots , ArrayList<Slot> sl) {
		//this.setId();
		this.noOfSLot = slots;
		this.slotsList = sl;
	}



//	public int getId() {
//		return id;
//	}
//
//
//
//	public void setId() {
//		this.id = ID.incrementAndGet();
//	}



	public int getNoOfSLot() {
		return noOfSLot;
	}



	public List<Slot> getSlotsList() {
		return slotsList;
	}



	public void setSlotsList(List<Slot> slotsList) {
		this.slotsList = slotsList;
	}



	public void setNoOfSLot(int noOfSLot) {
		this.noOfSLot = noOfSLot;
	}
	
	
	
}
