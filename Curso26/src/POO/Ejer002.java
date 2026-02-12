package POO;

class Alumno {
	String nombre;
	String apellido;
	private String dni;
	
	public String getDNI() {
		return this.dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
}	
	
	
public class Ejer002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno a1 = new Alumno();
		
		a1.nombre = "Paco";
		a1.apellido = "Pérez";
		
		a1.setDNI("123456N");
		
		System.out.println("Alumno: " + a1.nombre + "\nApellido: " + a1.apellido + "\nDNI: " + a1.getDNI());
		
		
	}

}
