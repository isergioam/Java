package MVC;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ej02_Vista {

	public void mostrarListado(ArrayList<Ej01_Modelo> personas) {
		for (int i = 0; i < personas.size(); i++) {
			Ej01_Modelo p = personas.get(i);
			System.out.println((i + 1) + ") " + p.getNombre() + " " + p.getApellidos() + " (" + p.getEdad() + ")");
		}
	}

	public void error(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
