package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.Vehicle;



public class VehicleRepository {

	private static List<Vehicle> vehicles = new ArrayList<>();
	
	public VehicleRepository(){
		
	}
	
	public static List<Vehicle> getAllVehicles(){
		return new ArrayList<>(vehicles);
	}
	
	
	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
}
