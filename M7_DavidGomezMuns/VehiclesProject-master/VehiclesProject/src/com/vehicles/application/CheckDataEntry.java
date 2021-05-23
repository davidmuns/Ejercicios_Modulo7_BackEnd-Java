package com.vehicles.application;

import javax.swing.JOptionPane;

public class CheckDataEntry {
	
	public static void checkPlate(String plate) throws Exception {
		
		int contNum = 0, contChar = 0;
		for(int i = 0; i < plate.length(); i++){
			if(plate.codePointAt(i) >= 48 && plate.codePointAt(i) <= 57) {
				contNum++;
			}else {
				contChar++;
			}
		}
		if (contNum != 4 || contChar < 2 || contChar > 3) {
			throw new Exception();
			
		}
		
	}
	
	public static String checkIfDouble(String diameter) {
		try {
			Double.parseDouble(diameter);
			return diameter;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor incorrecto");
			System.exit(0);
			return null;
		}
		
	}
	public static void checkDiameter(double diameter) throws Exception{
		if(diameter < 0.4 || diameter > 4) {
			throw new Exception();
		}
	}
}
