package MVC;

import javax.swing.JOptionPane;

public class Ej04_Vista {

	public void mostrarCurso(String nombre, int horas) {
		JOptionPane.showMessageDialog(null,
				"⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ Nombre del curso: " + nombre + "\n ✜ Horas: " + horas + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥",
				"Información", JOptionPane.CLOSED_OPTION);
	}

}
