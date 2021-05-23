package com.vehicles.domain;

public class Conductor extends Persona{
	
	protected boolean license;

	public Conductor(String nombre, String apellido, int year, int month, int day, boolean license) {
		super(nombre, apellido, year, month, day);
		this.license = license;
	}

}
