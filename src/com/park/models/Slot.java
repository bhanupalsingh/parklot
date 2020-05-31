package com.park.models;

public class Slot {
	private int id;
	private Status status;
	private Car car;
	
	public Slot(int id , Car car) {
		this.id = id;
		this.status = Status.FREE;
		this.car = car;
	}
	
	
	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
