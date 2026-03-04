package MVC_Gestor_Tareas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TareasVista {
	public void mostrarTareas(ArrayList<Tarea> tarea) {

		for (int i = 0; i < tarea.size(); i++) {
			Tarea c = tarea.get(i);
			JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ #" + (i + 1) + "\n ✜ Nombre: " + c.getTitulo()
					+ "\n ✜ Resuelta: " + c.isHecha() + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥", "TAREAS", JOptionPane.CLOSED_OPTION);
		}

	}

	public void mostrarTotal(ArrayList<Tarea> tarea) {
		JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ TOTAL: " + tarea.size() + "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥",
				"TAREAS", JOptionPane.CLOSED_OPTION);
	}
}
