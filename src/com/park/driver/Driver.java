package com.park.driver;

import java.util.Scanner;

import com.park.models.Car;
import com.park.services.ParkingManager;
import com.park.services.ParkingService;

public class Driver {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ParkingService ps = ParkingService.getInstance();
		while(true){
			String input = sc.nextLine();
			String[] in = input.split(" ");
			String entity = in[0];
			try {
				switch(entity) {
				case "create_parking_lot":
					ps.createParkingLot(Integer.parseInt(in[1]));
					break;
				case "park":
					Car car = new Car(in[1] , in[2]);
					ps.addCar(car);
					ps.parkCar(car);
					break;
				case "leave":
					int slotNo = Integer.parseInt(in[1]);
					ps.vacantSlote(slotNo);
					break;
				case "status":
					ps.status();
					break;
				case "registration_numbers_for_cars_with_colour":
					ps.registerNoCarByColor(in[1]);
					break;
				case "slot_numbers_for_cars_with_colour":
					ps.slotByColor(in[1]);
					break;
				case "slot_number_for_registration_number":
					String regNo = in[1];
					ps.slotsByNumber(regNo);
					break;
				default:
					System.out.println("wrong command.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
					
			}
				 
		}	
		
	
}
