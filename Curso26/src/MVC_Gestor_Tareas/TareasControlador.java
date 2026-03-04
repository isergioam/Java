package MVC_Gestor_Tareas;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TareasControlador {
	private TareasModel modelo;
	private TareasVista vista;

	public TareasControlador(TareasModel modelo, TareasVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void addTareas(String titulo) {
		
		if (titulo.isBlank()) {
			JOptionPane.showMessageDialog(null, "La tarea no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Tarea t = new Tarea(titulo);
		modelo.add(t);
	}

	public void marcarHecha(int i) {
		if(i < 0 || i >= modelo.getTareas().size()) {
			JOptionPane.showMessageDialog(null, "Esa tarea no existe", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		modelo.marcarTarea(i);
	}

	public void mostrarTareas() {
		ArrayList<Tarea> tareas = modelo.getTareas();
		vista.mostrarTareas(tareas);
		vista.mostrarTotal(tareas);
	}
	
	public void borrarTarea(int n) {
		modelo.getTareas().remove(n);
		
	}

}
