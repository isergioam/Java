package POO;

public class Ejer010 {
	
	String nombre;
	String puesto;
	int salario;
	
	public Ejer010() {
		this.nombre = "Sin nombre";
		this.puesto = "Sin puesto";
		this.salario = 0;
	}
	public Ejer010(String nombre) {
		this.nombre = nombre;
		this.puesto = "Sin puesto";
		this.salario = 0;
	}
	public Ejer010(String nombre, String puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = 0;
	}
	public Ejer010(String nombre, String puesto, int salario) {
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
	}
	
	public void mostrar(){
		System.out.println("Nombre: " + this.nombre + "\nPuesto: " + this.puesto + "\nSalario: " + this.salario + "€");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejer010 e = new Ejer010();
		e.mostrar();
		Ejer010 e1 = new Ejer010("Paco");
		e1.mostrar();
		Ejer010 e2 = new Ejer010("Paco", "Profe");
		e2.mostrar();
		Ejer010 e3 = new Ejer010("Paco","Profe", 180000);
		e3.mostrar();

	}

}
