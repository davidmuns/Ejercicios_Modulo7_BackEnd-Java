package com.vehicles.view;

import javax.swing.JOptionPane;
import com.vehicles.application.Concesionario;
import com.vehicles.domain.DrivingLicense;
import com.vehicles.domain.TitularVehiculo;
import com.vehicles.persistence.VehicleRepository;

public class Main {

	public static void main(String[] args) {
		
		String tipoVehiculo = "";
		String nombreTitular = "David";
		String apellidoTitular = "Gomez Muns";
		String tipoLicencia = "Moto";
		
		int vehicleAmount = 2;
		int numWheels = 0;
		int anyoNacimiento = 1980;
		int mesNacimiento = 7;
		int diaNacimiento = 5;
		int anyoCaducidadLicencia = 2025;
		int mesCaducidadLicencia = 1;
		int diaCaducidadLicencia = 30;
		
		
		boolean licencia = true;
		boolean seguro = true;
		boolean parking = true;
		
		TitularVehiculo titular = new TitularVehiculo(nombreTitular, apellidoTitular, anyoNacimiento, mesNacimiento, diaNacimiento, licencia, seguro, parking);
		titular.createLicense(tipoLicencia, anyoCaducidadLicencia, mesCaducidadLicencia, diaCaducidadLicencia);
		
		
		
		for(int i = 1; i <= vehicleAmount; i++) {
			
			if(!DrivingLicense.checkIfDrivingLicense(nombreTitular + " " + apellidoTitular)) break;
				
			String opcion = JOptionPane.showInputDialog(null, "Selecciona el tipo de vehículo:\n1. Coche\n2. Moto\n3. Camión", 
													   "VEHÍCULO " + i + " de " + vehicleAmount, 3);
			if(opcion == null) System.exit(0);
			
			Concesionario c = new Concesionario(opcion);
			
			if (opcion.equals("1")) {
				
				tipoVehiculo = "COCHE";
			
			}else if(opcion.equals("2")) {
				
				tipoVehiculo = "MOTO";
			}else {
				
				tipoVehiculo = "CAMION";	
			}
			
					
			if(opcion.equals("1")  || opcion.equals("2") || opcion.equals("3")) {
				
				Concesionario.pedirDatosComunes(tipoVehiculo);
							
				Concesionario.crearVehiculo();
							
				if(opcion.equals("1") || opcion.equals("3")) numWheels = 4;
					else numWheels = 2;			
			
				Concesionario.crearRuedas(numWheels);
				
				Concesionario.addRuedas();				
				
			}else {
				JOptionPane.showMessageDialog(null, "Opción no existe.", "ERROR", 0);
				break;
			}
		}
		
		if(!licencia) JOptionPane.showMessageDialog(null, "El titular " + nombreTitular + " " + apellidoTitular + " no tiene licencia.");	
		
		for(int i = 0; i < VehicleRepository.getAllVehicles().size(); i++) {
			System.out.println(VehicleRepository.getAllVehicles().get(i).toString() + "\n************");
		}
		
	}

}
