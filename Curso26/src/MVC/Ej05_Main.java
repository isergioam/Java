package MVC;

public class Ej05_Main {

	public static void main(String[] args) {
		Ej05_Modelo m = new Ej05_Modelo();
		Ej05_Vista vista = new Ej05_Vista();
		Ej05_Controlador c = new Ej05_Controlador(m, vista);

		/*c.addAlumno("Paco", "Palacios", 57);
		c.addAlumno("Sergio", "Aguilar", 39);
		c.addAlumno("Pilar", "Fernández", 37);*/

		c.mostrarInfo();
		

	}

}
