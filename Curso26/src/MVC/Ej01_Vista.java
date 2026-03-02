package MVC;

import javax.swing.*;

public class Ej01_Vista {
	// mostrar persona
	public void mostrarPersona(String nombre, String apellidos, int edad) {
		JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ Nombre: " + nombre + "\n ✜ Apellidos: " + apellidos + "\n ✜ Edad: " + edad + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥", "Usuario", JOptionPane.CLOSED_OPTION);
	}
	
	public void error(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
