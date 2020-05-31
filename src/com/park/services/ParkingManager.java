package com.park.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.park.models.Car;
import com.park.models.Color;
import com.park.models.ParkingLot;
import com.park.models.Slot;
import com.park.models.Status;

public class ParkingManager {
	//right not only we go with 1 parking Lot
	private ParkingLot parkingLot;
	private HashMap<String , Car> carList = new HashMap<>();
	
	
	
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public HashMap<String, Car> getCarList() {
		return carList;
	}

	public void setCarList(HashMap<String, Car> carList) {
		this.carList = carList;
	}

	public void addCar(Car car) {
		this.carList.put(car.getRegNo(), car);
	}
	
	public void addParkingLot(ParkingLot parkingLot) {
		// multiple parking lot support
		
	}	
	
}
