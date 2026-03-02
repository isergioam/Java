package MVC;

public class Ej02_Controlador {

	private Ej02_Modelo modelo;
	private Ej02_Vista vista;
	
	public Ej02_Controlador(Ej02_Modelo modelo, Ej02_Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void addPersona(String nombre, String apellidos, int edad) {
		if(nombre.length() < 3 || apellidos.length() < 3) {
			vista.error("El nombre o apellidos deben tener más de 3 caracteres.");
			return;

		}	
			
		if (edad < 0) {
			vista.error("El número debe ser positivo");
			return;
		} 
			Ej01_Modelo p = new Ej01_Modelo(nombre, apellidos, edad);
			
			modelo.add(p);
	}
	
	public void mostrarListado() {
		vista.mostrarListado(modelo.getPersonas());
	}
	
	
	
}
