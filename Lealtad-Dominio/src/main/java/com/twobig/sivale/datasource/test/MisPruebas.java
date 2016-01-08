package com.twobig.sivale.datasource.test;

import java.util.ArrayList;
import java.util.List;


public class MisPruebas {
	
	public static void main(String[] args){
		
		List<String> lista = new ArrayList<String>();
		
		lista.add(new String("Uno"));
		lista.add(new String("Dos"));
		lista.add(new String("Tres"));
		lista.add(new String("Cueatro"));
		lista.add(new String("Cinco"));
		
		
//		for (String string : lista) {
//			System.out.println(string.toLowerCase());
//		}
//		
//		for (String string : lista) {
//			System.out.println(string);
//		}
		
		String cadena = "CINco";
		
		for (String string : lista) {
			if(string.toLowerCase().indexOf(cadena.toLowerCase()) != -1){
				System.out.println(string);
			}
		}
		
	}
}
