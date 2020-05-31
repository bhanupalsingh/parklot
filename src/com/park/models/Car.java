package com.park.models;

public class Car {
	private String regNo;
	private Color color;
	
	
	public Car(String regNo , String color) {
		this.regNo = regNo;
		this.color = Color.valueOf(color.toUpperCase());
	}
	
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
