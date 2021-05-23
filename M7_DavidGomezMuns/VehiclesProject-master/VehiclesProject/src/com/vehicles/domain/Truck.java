package com.vehicles.domain;

import java.util.List;

public class Truck extends Vehicle{

	public Truck(String plate, String brand, String color) {
		super(plate, brand, color);
		// TODO Auto-generated constructor stub
	}
	
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	
	}

	private void addTwoWheels(List<Wheel> wheels) throws Exception {
		
		if (wheels.size() != 2) {
			throw new Exception();
		}
			
		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
			
		
	}

	@Override
	public String toString() {
		return "Truck [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}


}
