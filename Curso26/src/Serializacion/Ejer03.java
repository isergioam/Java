package Serializacion;

import java.io.*;
import java.util.ArrayList;

class Libros implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String titulo;
	String autor;

	public Libros(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return titulo + " - " + autor;
	}

}

public class Ejer03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Libros> libro = new ArrayList<>();
		libro.add(new Libros("Don Quijote de la Mancha", "Miguel de Cervantes"));
		libro.add(new Libros("EL Señor de los Anillos", "J.R.Tolkien"));

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializacion/Ejer03_libros.dat"))) {

			oos.writeObject(libro);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializacion/Ejer03_libros.dat"))) {
			@SuppressWarnings("unchecked")
			ArrayList<Libros> leidos = (ArrayList<Libros>) ois.readObject();
			for (Libros libros : leidos) {
				System.out.println(libros);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
