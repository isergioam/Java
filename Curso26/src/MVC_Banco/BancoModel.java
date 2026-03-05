package MVC_Banco;

import java.util.ArrayList;

public class BancoModel {

	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	
	public void addCuenta(Cuenta c) {
		cuentas.add(c);
	}
	
	public ArrayList<Cuenta> getCuentas(){
		return cuentas;
	}
	
}
