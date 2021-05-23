package com.vehicles.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Persona {
	
	protected String nombre, apellido;
	protected Date dateOfBirth;
	
	public Persona(String nombre, String apellido, int year, int month, int day) {
		this.nombre = nombre;
		this.apellido = apellido;
		GregorianCalendar c = new GregorianCalendar(year, month-1, day);
		this.dateOfBirth = c.getTime();
	
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dateOfBirth=" + sdf.format(dateOfBirth) + "]";
	}
	 
	 

}
