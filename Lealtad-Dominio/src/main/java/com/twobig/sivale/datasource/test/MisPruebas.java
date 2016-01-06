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
		
		if(lista.contains(new String("Tress"))){
			System.out.println("Existe el elemento");
		}
		else
			System.out.println("No existe elemento");
	}
}
