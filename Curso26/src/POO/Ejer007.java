package POO;

public class Ejer007 {

	String nombre;
	double precio;

	public double precioConDescuento(double porcentaje) {
		if (porcentaje < 0 || porcentaje > 100) {
			System.out.println("Porcentaje incorrecto");
		} else {
			this.precio = this.precio - (this.precio * porcentaje) / 100;
		}
		return this.precio;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ejer007 e = new Ejer007();
		e.nombre = "Paco";
		e.precio = 20;
		double descuento = e.precioConDescuento(25);
		
		System.out.println("El precio con el descuento es: " + descuento + "€");
		
	}

}
