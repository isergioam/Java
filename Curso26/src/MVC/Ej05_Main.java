package MVC;

import java.util.ArrayList;

public class Ej05_Main {

	public static void main(String[] args) {
		Ej03_Modelo m = new Ej03_Modelo("DNI", "Paco", "Palacios", "paco@paco.com");
		Ej03_Vista vista = new Ej03_Vista();
		Ej03_Controlador c = new Ej03_Controlador(m, vista);

		c.mostrarInfo();

		Ej04_Modelo curso = new Ej04_Modelo("Fullstack con Java", 300);
		Ej04_Vista v = new Ej04_Vista();
		Ej04_Controlador controlador = new Ej04_Controlador(curso, v);

		controlador.mostrarInfo();

		ArrayList<Ej03_Modelo> alumnos = new ArrayList<>();

		Ej05_Modelo a = new Ej05_Modelo(alumnos, curso);

		a.add(m);

		Ej05_Vista aulaVista = new Ej05_Vista();

		Ej05_Controlador control = new Ej05_Controlador(a, aulaVista);

		control.mostrarInfo();

	}

}
