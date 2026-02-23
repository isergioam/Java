package Swing;

import javax.swing.JOptionPane;

public class Ejer06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] ops = { "AÑADIR(+)", "SACAR(-)", "VER AFORO", "SALIR" };
		boolean salir = false;
		int max = 50;
		int actual = 0;

		while (!salir) {
			int op = JOptionPane.showOptionDialog(null, "Elige una opción:", "CONTROL DE AFORO",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);
			if (op == 0) {

				if (actual < max) {
					actual++;
				} else {
					JOptionPane.showMessageDialog(null, "Foro máximo superado o cantidad no permitida.");
				}
			}
			if (op == 1) {

				if (actual < 1) {
					JOptionPane.showMessageDialog(null, "Aforo vacío.");
				} else {
					actual--;
				}
			}

			if (op == 2) {
				JOptionPane.showMessageDialog(null, "Aforo actual: " + actual);
			}

			if (op == 3 || op == -1) {
				JOptionPane.showMessageDialog(null, "Operación cancelada.", "Fin", JOptionPane.INFORMATION_MESSAGE);
				salir = true;
			}

		}

	}
}
