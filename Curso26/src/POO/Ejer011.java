package POO;

import java.util.Scanner;

public class Ejer011 {
	String nombre;
	int edad;
	
	public Ejer011(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;	

	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce tu edad: ");
		int edad = sc.nextInt();

		Ejer011 e = new Ejer011(nombre, edad);
		System.out.println("Tu nombre es: " + e.nombre + " y tu edad es: " + e.edad);

		sc.close();
	}

}
