package Serializacion;

import java.io.*;

class Libro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String titulo;
	String autor;

	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return titulo + " - " + autor;
	}

}

public class Ejer02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Libro l1 = new Libro("El señor de los Anillos", "J.R. Tolkien");
		Libro l2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes");

		// Escritura de archivo
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/Serializacion/Ejer02_biblioteca.dat"))) {

			oos.writeObject(l1);
			oos.writeObject(l2);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// Leer de archivo
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializacion/Ejer02_biblioteca.dat"))){
			
			Libro leido1 = (Libro) ois.readObject();
			Libro leido2 = (Libro) ois.readObject();
			
			System.out.println(leido1);
			System.out.println(leido2);
			
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
