package MVC;

public class Ej02_Main {

	public static void main(String[] args) {

		Ej02_Modelo m = new Ej02_Modelo();
		Ej02_Vista vista = new Ej02_Vista();
		Ej02_Controlador c = new Ej02_Controlador(m, vista);

		c.addPersona("Paco", "Palacios", 57);
		c.addPersona("Sergio", "Aguilar", 39);
		c.addPersona("Pilar", "Fernández", 37);

		c.mostrarListado();

	}

}
