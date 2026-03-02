package MVC;

public class Ej03_Controlador {
	private Ej03_Modelo modelo;
	private Ej03_Vista vista;

	public Ej03_Controlador(Ej03_Modelo modelo, Ej03_Vista vista) {
		this.modelo = modelo;
		this.vista = vista;

	}

	public void mostrarInfo() {
		String dni = modelo.getDni();
		String nombre = modelo.getNombre();
		String apellidos = modelo.getApellidos();
		String email = modelo.getEmail();

		vista.mostrarPersona(dni, nombre, apellidos, email);

	}

}
