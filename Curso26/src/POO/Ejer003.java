package POO;

class Curso {
	String nombre;
	private int alumnos;
	int duracion;

	public int getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(int alumnos) {
		if (alumnos >= 0 && alumnos <= 15) {
			this.alumnos = alumnos;
		} else {
			System.out.println("Alumno no válido.");
		}

	}

	public void verINFO() {
		System.out.println("Nombre del curso: " + this.nombre);
		System.out.println("Número de alumnos: " + this.getAlumnos());
		System.out.println("Duración del curso: " + this.duracion + " horas");
		
	}

}

public class Ejer003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Curso c = new Curso();
		c.nombre = "JAVA";
		c.duracion = 500;

		c.setAlumnos(10);

		c.verINFO();

		/*System.out.println("Nombre del curso: " + c.nombre + "\nAlumnos: " + c.getAlumnos() + "\nDuración: "
				+ c.duracion + " horas");*/

	}

}
