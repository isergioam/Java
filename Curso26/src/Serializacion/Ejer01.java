package Serializacion;

import java.io.*;

class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	int edad;

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nEdad: " + edad;
	}

}

public class Ejer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/Serializacion/Ejer01_personas.dat"))) {
			oos.writeObject(new Persona("Ana", 30));
			oos.writeObject(new Persona("Luis", 25));
		} catch (IOException e) {
			e.printStackTrace(); // pintame todos los errores que ocurran
		}

		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/Serializacion/Ejer01_personas.dat"))) {
			Persona p1 = (Persona) ois.readObject();
			Persona p2 = (Persona) ois.readObject();
			System.out.println(p1);
			System.out.println(p2);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
