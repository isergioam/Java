package Archivos;

import java.io.*;


public class Ejer03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String[] nombres = {"Paco", "Juan", "Pepe", "Andres", "María", "Ana", "Sergio"};
		int lineas = 0;
		
		for(int i = 0; i < nombres.length; i++) {
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/Archivos/nombres.txt", true))) {
				
				bw.write(nombres[i]);
				bw.newLine();
				

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

			try (BufferedReader br = new BufferedReader(new FileReader("src/Archivos/nombres.txt"))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}

			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			lineas += i;
			
			System.out.println("Nuestro archivo tiene " + lineas + " lineas.");
		
		} 
		
		
	}

}
