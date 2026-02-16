package POO;

abstract class Cuenta2 {
	String titular;
	double saldo;

	public abstract double comisionMensual();

	public void ingresar(double cant) {
		this.saldo = this.saldo + cant - this.comisionMensual();
	}
	
	public void retirar(double cant) {
		this.saldo = this.saldo - cant - this.comisionMensual();
	}

}

class CuentaAhorro2 extends Cuenta2{
	double comision = 0.20;
	public double comisionMensual() {
		return saldo * this.comision;
	}

}

class CuentaEmpresa extends Cuenta2{
		double comision = 0.10;
		public double comisionMensual() {
			return saldo * this.comision;
		}

}

public class Ejer029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaEmpresa ce = new CuentaEmpresa();
		ce.saldo = 100000;
		ce.ingresar(2000);

		System.out.println(ce.saldo);
	}

}
