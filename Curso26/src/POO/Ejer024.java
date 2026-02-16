package POO;

import java.util.ArrayList;

class Moderador {

	ArrayList<String> baneados = new ArrayList<>();

	public void banear(String nick) {
		baneados.add(nick);

		System.out.println("<- Usuario " + nick + " ha sido bloqueado.");

	}

	public void desbanear(String nick) {
		baneados.remove(nick);

		System.out.println("-> Usuario " + nick + " ha sido desbloqueado.");

	}

	public void estaBaneado(String nick) {
		if (nick == null || nick.isBlank()) {
			System.out.println("Error al introducir los datos.");
		} else {
			if (baneados.contains(nick)) {
				System.out.println("El Usuario " + nick + " está baneado.");
			} else {
				System.out.println("El Usuario " + nick + " no está baneado.");
			}
		}

	}

	public void listar() {
		System.out.println("/// USUARIOS BLOQUEADOS ///");

		for (String usuario : baneados) {
			System.out.println("- " + usuario);
		}

	}

}

public class Ejer024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Moderador e = new Moderador();
		e.banear("Paco");
		e.banear("Pepe");
		e.banear("Juan");
		e.listar();
		e.desbanear("Pepe");
		e.listar();
		e.estaBaneado("Pepe");
		e.estaBaneado("");
		e.listar();

	}

}
