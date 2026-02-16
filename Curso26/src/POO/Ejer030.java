package POO;

interface Pagable {
	double importe();
}

class Factura implements Pagable {

	double base;
	double iva;

	public double importe() {
		return base * (1 + iva);
	}

}

class Subscripcion implements Pagable {
	double base;
	int meses;

	public double importe() {
		return base * meses;
	}
}

public class Ejer030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factura f = new Factura();
		f.base = 1000;
		f.iva = 0.21;

		Subscripcion s = new Subscripcion();
		s.base = 200;
		s.meses = 12;

		System.out.println("Factura: " + f.importe() + "€");
		System.out.println("Suscripción: " + s.importe() + "€");

	}

}
