package MVC_Banco;

import java.util.ArrayList;

public class BancoController {

	private BancoModel banco;
	private BancoVista vista;

	public BancoController(BancoModel banco, BancoVista vista) {
		this.banco = banco;
		this.vista = vista;
	}

	public void addCuenta(int numeroCuenta, String titular, double saldo) {
		if (titular.length() == 0 || titular.isBlank()) {
			vista.msjError("El titular no existe");
			return;
		}

		if (numeroCuenta <= 0) {
			vista.msjError("El número de cuenta no puede ser negativo o cero");
			return;
		}

		if (saldo <= 0) {
			vista.msjError("El saldo no puede ser negativo o cero");
			return;
		}

		
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = banco.getCuentas();
		for(Cuenta c : cuentas) {
			if(c.getNumeroCuenta() == numeroCuenta) {
				vista.msjError("El número de cuenta ya existe");
				return;
			} 
		}
		Cuenta c = new Cuenta(numeroCuenta, titular, saldo);
		banco.addCuenta(c);
	}

	public void ingresarCuenta(int numeroCuenta, double ingreso) {

		if (ingreso <= 0) {
			vista.msjError("El ingreso en cuenta no puede ser negativo o cero");
			return;
		}

		if (numeroCuenta <= 0) {
			vista.msjError("El número de cuenta no puede ser negativo o cero");
			return;
		}

		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = banco.getCuentas();
		for (Cuenta c : cuentas) {
			if (c.getNumeroCuenta() == numeroCuenta) {
				double saldoAntiguo = c.getSaldo();
				double saldoNuevo = saldoAntiguo + ingreso;
				c.setSaldo(saldoNuevo);
				return;
			}
		}
		vista.msjError("Cuenta bancaria no encontrada.");

	}

	public void retirarCuenta(int numeroCuenta, double retiro) {
		if (retiro <= 0) {
			vista.msjError("No puede retirar una cantidad negativa o cero");
			return;
		}

		if (numeroCuenta <= 0) {
			vista.msjError("El número de cuenta no puede ser negativo o cero");
			return;
		}
		
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = banco.getCuentas();
		for(Cuenta c : cuentas) {
			if(c.getNumeroCuenta() == numeroCuenta) {
				double saldoAntiguo = c.getSaldo();
				double saldoNuevo = saldoAntiguo - retiro;
				c.setSaldo(saldoNuevo);
				return;
			}
		}
		vista.msjError("Cuenta bancaria no encontrada.");
	}

	public void mostrarInfo() {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = banco.getCuentas();
		vista.listarCuentas(cuentas);

	}

	public void mostrarSaldo(String titular) {

	}

}
