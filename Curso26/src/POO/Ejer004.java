package POO;

class CuentaBancaria {
	String titular;
	int cant;
	
	public void ingresarSaldo(int saldo) {
		this.cant = this.cant + saldo;
		this.verINFO();
	}
	
	public void retirarSaldo(int saldo) {
		if (saldo > this.cant) {
			System.out.println("Operación imposible.");
		} else {
			this.cant = this.cant - saldo;
		}
		this.verINFO();
	}

	public void verINFO() {
		System.out.println("Titular de la cuenta: " + this.titular);
		System.out.println("Saldo en cuenta: " + this.cant);

	}

}

public class Ejer004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CuentaBancaria d = new CuentaBancaria();
		d.titular = "PACO";
		d.ingresarSaldo(5000000);
		
		d.retirarSaldo(50000);
	}

}
