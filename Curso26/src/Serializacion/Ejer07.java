package Serializacion;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Cita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fecha;
	String hora;
	String texto;

	public Cita(String fecha, String hora, String texto) {
		this.fecha = fecha;
		this.hora = hora;
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Cita del día " + fecha + " a las " + hora + "\n" + texto;
	}
	

}

public class Ejer07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean salir = false;
		Scanner sc = new Scanner(System.in);
		 
	
		while (!salir) {
			System.out.println("/////////// AGENDA //////////\n|| 1 AÑADIR CITA || 2 LISTADO || 3 SALIR ||");

			int op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1:
				System.out.println("Introduzca la fecha (00/00/0000): ");
				String f = sc.nextLine();
				
				System.out.println("Introduzca la hora (00:00:00): ");
				String h = sc.nextLine();
				
				System.out.println("Introduzca la descripción: ");
				String d = sc.nextLine();
				
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializacion/Ejer07_citas.bin"))) {
					oos.writeObject(new Cita(f,h,d));
					
				}catch(IOException e){
					System.out.println(e.getMessage());
					
				}	
				break;
				
			case 2:
	
				
				try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializacion/Ejer07_citas.bin"))) {
					@SuppressWarnings("unchecked")
					ArrayList<Cita> obj = (ArrayList<Cita>) ois.readObject();
					for (Cita i : obj) {
						System.out.println(i);
					}
					
				}catch(IOException | ClassNotFoundException e){
					System.out.println(e.getMessage());
					
				}	
				break;

			case 3:
				salir = true;
				System.out.println("Programa finalizado.");

				break;

			}

		}
		sc.close();
	}

}
