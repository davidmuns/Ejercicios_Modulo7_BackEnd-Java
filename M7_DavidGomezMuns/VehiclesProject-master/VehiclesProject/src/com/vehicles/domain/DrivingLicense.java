package com.vehicles.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

public class DrivingLicense {
	
	private int id;
	private static int incrementID = 100;
	private String nombreCompleto;
	private String type;
	private Date fechaCaducidad;
	private static List<DrivingLicense> drivingLicenseList = new ArrayList<DrivingLicense>();
	
	public DrivingLicense(String name, String apellido, int year, int month, int day, String type) {
		id = incrementID;
		incrementID += 10;
		nombreCompleto = name + " " + apellido;
		GregorianCalendar c = new GregorianCalendar(year, month-1, day);
		fechaCaducidad = c.getTime();
		this.type = type;
	}
	public static void addDrivingLicense(DrivingLicense dl) {
		drivingLicenseList.add(dl);
	}
	
	public static boolean checkIfDrivingLicense (String name){
		int cont = 0;
		boolean drivingLisence = false;
		
		for(DrivingLicense dl: drivingLicenseList) {
			if(dl.nombreCompleto.equalsIgnoreCase(name)){
				cont++;
				JOptionPane.showMessageDialog(null, dl, "DATOS LICENCIA", 3);
			}
		}
		if(cont != 0) drivingLisence = true;
		return drivingLisence;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
		
		sb.append("Nº: ").append(id);
		sb.append("\nNombre y apellidos: ").append(nombreCompleto);
		sb.append("\nTipo: ").append(type);
		sb.append("\nFecha Caducidad: ").append(sdf.format(fechaCaducidad));
	
		return sb.toString();
	}

	
	
	
}
