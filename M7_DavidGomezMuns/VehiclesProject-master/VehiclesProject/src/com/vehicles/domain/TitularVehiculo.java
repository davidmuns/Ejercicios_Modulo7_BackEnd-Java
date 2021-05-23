package com.vehicles.domain;

import java.text.SimpleDateFormat;

public class TitularVehiculo extends Conductor{
	
	private boolean insurance, parking;
	
	public TitularVehiculo(String nombre, String apellido, int year, int month, int day, boolean license, boolean insurance, boolean parking) {
		super(nombre, apellido, year, month, day, license);
		this.insurance = insurance;
		this.parking = parking;
	}
	
	public void createLicense(String type, int year, int month, int day) {
		if (license) {
			DrivingLicense.addDrivingLicense(new DrivingLicense(this.nombre, this.apellido, year, month, day, type));		
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
		return "TitularVehiculo [nombre=" + nombre + ", apellido="
				+ apellido + ", dateOfBirth=" + sdf.format(dateOfBirth) + ", license=" + license + ", insurance=" + insurance + ", parking=" + parking  + "]";
	}
	

	

}
