package MVC;

public class Ej04_Main {

	public static void main(String[] args) {

		Ej04_Modelo m = new Ej04_Modelo("", 0);
		Ej04_Vista vista = new Ej04_Vista();
		Ej04_Controlador c = new Ej04_Controlador(m, vista);

		m.setNombre("JAVA Fullstack");
		m.setHoras(300);

		c.mostrarInfo();
	}

}
