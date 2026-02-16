package POO;

abstract class Empleado3 {
	String nombre;

	public abstract void calcularSueldo();
}

class EmpleadoFijo2 extends Empleado3{
	int sueldo;
	
	public void calcularSueldo() {
		System.out.println("EL sueldo de " + this.nombre + " es: " + this.sueldo + "€");
	}
	
class EmpleadoPorHoras extends Empleado3{
	int sueldoHora;
	int horas;
	
	public EmpleadoPorHoras(int sueldoHora, int horas) {
		this.sueldoHora = sueldoHora;
		this.horas = horas;
	}
	
	public void calcularSueldo() {
		int sueldo = this.sueldoHora * this.horas;
		System.out.println("EL sueldo de " + this.nombre + " es: " + sueldo + "€");
		
	}
}
	
}


public class Ejer028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmpleadoFijo2 e1 = new EmpleadoFijo2();
		e1.sueldo = 18000;
		e1.nombre = "Paco";
		
		e1.calcularSueldo();
		

	}

}
