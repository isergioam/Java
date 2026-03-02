package MVC;

public class Ej04_Controlador {

	private Ej04_Modelo modelo;
	private Ej04_Vista vista;

	public Ej04_Controlador(Ej04_Modelo modelo, Ej04_Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void mostrarInfo() {
		String nombre = modelo.getNombre();
		int horas = modelo.getHoras();

		vista.mostrarCurso(nombre, horas);

	}

}
