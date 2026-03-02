package MVC;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ej05_Vista {

	public void mostrarListado(ArrayList<Ej03_Modelo> alumnos, String curso) {
		for (int i = 0; i < alumnos.size(); i++) {
			Ej03_Modelo a = alumnos.get(i);
			JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ DNI: " + a.getDni() + "\n ✜ Nombre: " + a.getNombre() + "\n ✜ Apellidos: " + a.getApellidos() + "\n ✜ Email: " + a.getEmail() + "\n ✜ Curso: " + curso + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥", "Usuario", JOptionPane.CLOSED_OPTION);
		}
	}
	
	
}
