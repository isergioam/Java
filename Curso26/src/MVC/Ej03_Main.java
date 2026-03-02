package MVC;

public class Ej03_Main {

	public static void main(String[] args) {

		Ej03_Modelo m = new Ej03_Modelo("", "", "", "");
		Ej03_Vista vista = new Ej03_Vista();
		Ej03_Controlador c = new Ej03_Controlador(m, vista);

		m.setDni("56803459B");
		m.setNombre("Sergio");
		m.setApellidos("Aguilar");
		m.setEmail("sergio@sergio.com");

		c.mostrarInfo();

	}

}
