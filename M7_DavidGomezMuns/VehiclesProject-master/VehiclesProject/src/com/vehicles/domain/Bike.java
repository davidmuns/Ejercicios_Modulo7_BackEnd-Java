package com.vehicles.domain;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	
	}
	private void addTwoWheels(List<Wheel> wheels) throws Exception {
		
		if (wheels.size() != 1)
			throw new Exception();
		
		this.wheels.add(wheels.get(0));
		
	}
	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels +"]";
	}
	
}
