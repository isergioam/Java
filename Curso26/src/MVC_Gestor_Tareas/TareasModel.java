package MVC_Gestor_Tareas;

import java.util.ArrayList;

public class TareasModel {

	private ArrayList<Tarea> tareas = new ArrayList<Tarea>();

	public void add(Tarea tarea) {
		tareas.add(tarea);
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void marcarTarea(int i) {
		Tarea miTarea = this.tareas.get(i);
		miTarea.setHecha(true);
	}

}
