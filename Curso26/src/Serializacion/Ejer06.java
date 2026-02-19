package Serializacion;

import java.io.*;

class Score implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nick;
	int puntos;

	public Score(String nick, int puntos) {
		this.nick = nick;
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Nick: " + nick + " ---> " + puntos + " puntos.";
	}

}

public class Ejer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Score p1 = new Score("Paco", 30);
		Score p2 = new Score("Juan", 7);
		Score p3 = new Score("Ana", 50);
		Score p4 = new Score("Pikachu", 3);
		Score p5 = new Score("Snorlax", 300);

		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/Serializacion/Ejer06_ranking.dat"))) {
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.writeObject(p4);
			oos.writeObject(p5);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/Serializacion/Ejer06_ranking.dat"))) {
			while (true) {
				Score s = (Score) ois.readObject();
				System.out.println(s);
			}

		} catch (EOFException e) {
			System.out.println("Fin del archivo");

			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());

		}
	}

}
