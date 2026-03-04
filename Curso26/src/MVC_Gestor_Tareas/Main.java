package MVC_Gestor_Tareas;

public class Main {

	public static void main(String[] args) {
		TareasModel modelo = new TareasModel();
		TareasVista vista = new TareasVista();
		TareasControlador c = new TareasControlador(modelo, vista);

		c.addTareas("Limpiar el Salón");
		c.addTareas("Poner lavadora");
		c.addTareas("Tender la ropa");
		c.addTareas("Sacar a los perros");
		
		c.marcarHecha(1);
		c.marcarHecha(3);
		
		c.mostrarTareas();
		
		c.borrarTarea(0);
		
		c.mostrarTareas();
	}

}
