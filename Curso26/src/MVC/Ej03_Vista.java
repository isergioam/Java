package MVC;

import javax.swing.JOptionPane;

public class Ej03_Vista {
	public void mostrarPersona(String dni, String nombre, String apellidos, String email) {
		JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ DNI: " + dni + "\n ✜ Nombre: " + nombre + "\n ✜ Apellidos: " + apellidos + "\n ✜ Edad: " + email + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥", "Usuario", JOptionPane.CLOSED_OPTION);
	}
	
	public void error(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
