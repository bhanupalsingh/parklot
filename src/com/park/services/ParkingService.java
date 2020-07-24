package com.park.services;

import java.util.ArrayList;
import java.util.List;

import com.park.models.Car;
import com.park.models.Color;
import com.park.models.ParkingLot;
import com.park.models.Slot;
import com.park.models.Status;

public class ParkingService {
	
	private static ParkingService parkingService = null;
	private ParkingManager parkingManager = null;
	private ParkingService() {
		parkingManager = new ParkingManager();
	}
	
	public static ParkingService getInstance() {
			if(parkingService == null) {
				parkingService = new ParkingService(); 
			}
			return parkingService;
	}
	
	
	public void addCar(Car car) {
		parkingManager.addCar(car);
	}
	
	public void createParkingLot(int slots){
		ArrayList<Slot> sl = new ArrayList<Slot>();
		for(int i=1;i<=slots;i++) {
			Slot slot = new Slot(i, null);
			sl.add(slot);
		}
		parkingManager.setParkingLot(new ParkingLot(slots,sl));
		System.out.println("Created a parking lot with "+slots+" slots ");
	}
	
	public void parkCar(Car car) {
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		boolean slotAvail = false;
		int id = 0;
		synchronized (this) {
			for(Slot slot : slotList) {
				if(slot.getStatus().equals(Status.FREE)) {
					slot.setStatus(Status.OCCUPIED);
					slot.setCar(car);
					id = slot.getId();
					slotAvail = true;
					break;
				}
			}
		}
		if(slotAvail == false) {
			System.out.println("Sorry, parking lot is full ");
		}else {
			System.out.println("Allocated slot number: "+id);
		}
		
		
				
				
	}
	
	public void vacantSlote(int slotNo) {
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		for(Slot slot : slotList) {
			if(slot.getId() == slotNo && slot.getStatus().equals(Status.OCCUPIED)) {
				slot.setStatus(Status.FREE);
				System.out.println("Slot number "+slotNo+" is free ");
				break;
			}
		}
	}
	
	
	public void status() {
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		System.out.println("Slot No.        Registration No       Color ");
		for(Slot slot : slotList) {
			if(slot.getStatus().equals(Status.OCCUPIED)) {
				System.out.println(slot.getId()+ "           "+slot.getCar().getRegNo() + "        " + slot.getCar().getColor());
			}
		}
	}
	
	
	public void registerNoCarByColor(String colorName) {
		Color color = Color.valueOf(colorName.toUpperCase());
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		ArrayList<String> regNoList = new ArrayList<String>();
		for(Slot slot : slotList) {
			if(slot.getStatus().equals(Status.OCCUPIED) && slot.getCar().getColor().equals(color)) {
				regNoList.add(slot.getCar().getRegNo());
			}
		}
		
		String delim = "";
		StringBuilder sb = new StringBuilder();
		for (String i : regNoList) {
		    sb.append(delim).append(i);
		    delim = ",";
		}
		
		System.out.println(sb.toString());
		
	}
	
	
	public void slotByColor(String colorName) {
		Color color = Color.valueOf(colorName.toUpperCase());
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		ArrayList<Integer> idList = new ArrayList<Integer>(); 
		for(Slot slot : slotList) {
			if(slot.getStatus().equals(Status.OCCUPIED) && slot.getCar().getColor().equals(color)) {
				idList.add(slot.getId());
				//System.out.println(slot.getId());
			}
		}
		
		
		String delim = "";
		StringBuilder sb = new StringBuilder();
		for (Integer i : idList) {
		    sb.append(delim).append(i);
		    delim = ",";
		}
		
		System.out.println(sb.toString());
	}
	
	
	public void slotsByNumber(String regNo) {
		List<Slot> slotList = parkingManager.getParkingLot().getSlotsList();
		boolean slotFound = false;
		for(Slot slot : slotList) {
			if(slot.getStatus().equals(Status.OCCUPIED) && slot.getCar().getRegNo().equals(regNo)) {
				System.out.println(slot.getId());
				slotFound = true;
				break;
			}
		}
		
		if(!slotFound) {
			System.out.println("Not Found");
		}
		
	}
	
}
