package Serializacion;

import java.util.ArrayList;
import java.io.*;

class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	int cantidad;

	public Item(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return nombre + " - " + cantidad;
	}

}

public class Ejer05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Item> item = new ArrayList<>();
		item.add(new Item("Hacha", 5));
		item.add(new Item("Pistola", 1));
		item.add(new Item("Escudo", 2));
		item.add(new Item("Antorcha", 20));

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializacion/Ejer05_mochila.bin"))) {
			oos.writeObject(item);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializacion/Ejer05_mochila.bin"))) {
			@SuppressWarnings("unchecked")
			ArrayList<Item> obj = (ArrayList<Item>) ois.readObject();
			for (Item i : obj) {
				System.out.println(i);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
