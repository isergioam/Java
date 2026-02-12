package POO;

public class Ejer008 {

	private double saldo;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositarSaldo(double dinero) {

		if (dinero < 0) {
			System.out.println("Cantidad incorrecta.");
		} else {
			this.saldo = dinero + saldo;
		}

	}

	public void retirarSaldo(double dinero) {
		if (dinero > saldo) {
			System.out.println("Cantidad incorrecta.");
		} else {
			this.saldo = saldo - dinero;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ejer008 e = new Ejer008();

		e.setSaldo(100);

		System.out.println("Su saldo es: " + e.getSaldo() + "€");

		e.depositarSaldo(-50);

		System.out.println("Su saldo es: " + e.getSaldo() + "€");

		e.retirarSaldo(200);

		System.out.println("Su saldo es: " + e.getSaldo() + "€");

	}

}
