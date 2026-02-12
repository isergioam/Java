package POO;

import Clases.Ejer006c;

public class Ejer006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ejer006c e1 = new Ejer006c();
		
		e1.setTemperatura(80);
		
		System.out.println("Temperatura actual: " + e1.getTemperatura() + "ºC");
		
		e1.bajarT(50);
		
		System.out.println("Temperatura actual: " + e1.getTemperatura() + "ºC");
		
		e1.subirT(20);
		
		System.out.println("Temperatura actual: " + e1.getTemperatura() + "ºC");
		
		
	}

}
