package Swing;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Ejer07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] ops = { "AÑADIR", "LISTAR", "SALIR" };
		ArrayList<String> total = new ArrayList<>();
		String inc;
		boolean salir = false;

		while (!salir) {
			int op = JOptionPane.showOptionDialog(null, "Selecciona una opción", "INCIDENCIAS", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			if (op == 0) {
				inc = JOptionPane.showInputDialog(null, "Introduzca la incidencia");
				total.add(inc);
			}

			if (op == 1) {
				
				String msj = "Listado de incidencias: \n";
				
				for (String m : total) {
					msj += " > " + m + "\n"; 
				}
				JOptionPane.showMessageDialog(null, msj, "INCIDENCIAS", JOptionPane.INFORMATION_MESSAGE);
			}

			if (op == 2 || op == -1) {
				JOptionPane.showMessageDialog(null, "Operación cancelada.", "INCIDENCIAS", JOptionPane.INFORMATION_MESSAGE);
				salir = true;
			}
		}

	}

}
