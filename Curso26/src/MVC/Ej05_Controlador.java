package MVC;

public class Ej05_Controlador {
	private Ej05_Modelo modelo;
	private Ej05_Vista vista;
	
	public Ej05_Controlador(Ej05_Modelo modelo, Ej05_Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void addAlumno(String dni, String nombre, String apellidos, String email) {


			Ej03_Modelo p = new Ej03_Modelo(dni, nombre, apellidos, email);
			
			modelo.add(p);
	}
	
	public void mostrarInfo() {
		vista.mostrarListado(modelo.getAlumnos(), modelo.getCurso());
	}

}
