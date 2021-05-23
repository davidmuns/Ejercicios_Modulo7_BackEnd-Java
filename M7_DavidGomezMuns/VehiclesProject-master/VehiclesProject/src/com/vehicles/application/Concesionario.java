package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.domain.Bike;
import com.vehicles.domain.Car;
import com.vehicles.domain.Truck;
import com.vehicles.domain.Wheel;
import com.vehicles.persistence.VehicleRepository;

public class Concesionario {
	private static List<Wheel> frontWheelList = new ArrayList<Wheel>();
	private static List<Wheel> backWheelList = new ArrayList<Wheel>();
	
	private static Car car;
	private static Bike bike;
	private static Truck truck;	
	private static Wheel backWheel, frontWheel;
	
	private static String opcion;
	private static String plate, brand, color;
	private static String wheelDiameterStr, wheelBrand;
	
	private static double wheelDiameter;
	
	private static int numWheels;
	

	public Concesionario(String opcion) {
		this.opcion = opcion;
	}

	public static void pedirDatosComunes(String tipoVehiculo) {
		
		boolean continuar = false;
		
		do {
			plate = JOptionPane.showInputDialog(null, "Introduce la matrícula (ej. \"0000KLM\" o  \"B0000KF\" )", tipoVehiculo, 3);	
			if(plate == null) System.exit(0);
			
			try {
				CheckDataEntry.checkPlate(plate);
				continuar = true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Formato de matrícula no válido.", "AVISO", 2);
				
			}
			
		} while (!continuar);
		
		
		brand = JOptionPane.showInputDialog(null, "Introduce la marca: ", tipoVehiculo, 3);
		if(brand == null) System.exit(0);
		
		color = JOptionPane.showInputDialog(null, "Introduce el color: ", tipoVehiculo, 3);
		if(color == null) System.exit(0);

	}

	public static void crearVehiculo() {
		
		if (opcion.equals("1")) {
			car = new Car(plate, brand, color);
			numWheels = 4;
		} else if (opcion.equals("2")) {
			bike = new Bike(plate, brand, color);
			numWheels = 2;
		} else if (opcion.equals("3")) {
			truck = new Truck(plate, brand, color);
			numWheels = 4;
		}
	}

	private static void pedirDatosRuedas(int i) {
		String wheelPosition = "";
		boolean continuar = false;
		
		if(opcion.equals("2")) {
			if (i == 1) wheelPosition = "TRASERA";
			if (i == 2) wheelPosition = "DELANTERA";
			
		}else {
			if (i == 1 || i == 2) wheelPosition = "TRASERA";
			if (i == 3 || i == 4) wheelPosition = "DELANTERA";		
		}

		wheelBrand = JOptionPane.showInputDialog(null, "Rueda " + i + ", posición " + wheelPosition + "\nIntroduce MARCA:", 
				"Crear RUEDAS (rueda " + i + " de " + numWheels + ")", 3);
		if(wheelBrand == null) System.exit(0);
		
		wheelDiameterStr = CheckDataEntry.checkIfDouble(JOptionPane.showInputDialog(null, 
				"Rueda " + i + ", posición " + wheelPosition + "\nIntroduce DIÁMETRO (entre 0.4 y 4.0):",
				"Crear RUEDAS (rueda " + i + " de " + numWheels + ")", 3));

		wheelDiameter = Double.parseDouble(wheelDiameterStr);

		try {
			CheckDataEntry.checkDiameter(wheelDiameter);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Diámetro fuera de rango.", "AVISO", 2);
			System.exit(0);
		}
	}

	public static void crearRuedas(int numWheels) {
		for (int i = 1; i <= numWheels; i++) {
			
			pedirDatosRuedas(i);
			
			if(opcion.equals("2")){
				if (i == 1) {
					backWheel = new Wheel(wheelBrand, wheelDiameter);
					backWheelList.add(backWheel);
				}
				if (i == 2) {
					frontWheel = new Wheel(wheelBrand, wheelDiameter);
					frontWheelList.add(frontWheel);
				}			
			}else {
				if (i == 1) {
					backWheel = new Wheel(wheelBrand, wheelDiameter);
					backWheelList.add(backWheel);
				}
				if (i == 2) {
					backWheel = new Wheel(wheelBrand, wheelDiameter);
					backWheelList.add(backWheel);
				}
				if (i == 3) {
					frontWheel = new Wheel(wheelBrand, wheelDiameter);
					frontWheelList.add(frontWheel);

				}
				if (i == 4) {
					frontWheel = new Wheel(wheelBrand, wheelDiameter);
					frontWheelList.add(frontWheel);
				}				
			}
		}
	}

	public static void addRuedas() {
		try {
			if (opcion.equals("1")) {
				car.addWheels(frontWheelList, backWheelList);
				VehicleRepository.addVehicle(car);
				backWheelList.clear();
				frontWheelList.clear();
			} else if (opcion.equals("2")) {
				bike.addWheels(frontWheelList, backWheelList);
				VehicleRepository.addVehicle(bike);
				backWheelList.clear();
				frontWheelList.clear();
			} else if(opcion.equals("3")) {
				truck.addWheels(frontWheelList, backWheelList);
				VehicleRepository.addVehicle(truck);
				backWheelList.clear();
				frontWheelList.clear();
			}
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Las ruedas tiene que ser de la misma marca y diámetro.", "AVISO", 3);
			System.exit(0);
		}
	}

}
