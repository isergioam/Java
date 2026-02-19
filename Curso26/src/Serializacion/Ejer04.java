package Serializacion;

import java.io.*;

class Partida implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int nivel;
	int vidas;
	int puntuacion;
	
	public Partida(int nivel, int vidas, int puntuacion) {
		this.nivel = nivel;
		this.vidas = vidas;
		this.puntuacion = puntuacion;
	}
	
	public String toString() {
		return "|| Nivel: " + nivel + " || Vidas: " + vidas + " || Puntuación: " + puntuacion + " ||";
	}	
}

public class Ejer04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Partida p = new Partida(50, 100, 500);		
		
		// ESCRIBIR
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializacion/Ejer04_partida.bin"))){
			oos.writeObject(p);			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		// LEER
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializacion/Ejer04_partida.bin"))){
			Partida entrada = (Partida)ois.readObject();
			System.out.println(entrada);
			
		} catch(IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

}
