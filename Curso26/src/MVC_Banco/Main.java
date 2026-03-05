package MVC_Banco;

public class Main {

	public static void main(String[] args) {
		BancoModel banco = new BancoModel();
		BancoVista vista = new BancoVista();
		BancoController c = new BancoController(banco, vista);

		c.addCuenta(3435366, "Sergio Aguilar", 500000);
		c.addCuenta(1212222, "Paco Palacios", 40000);
		c.addCuenta(6565658, "Santos Adivina", 1000);
		
		c.mostrarInfo();
		
		c.ingresarCuenta(1212222, 0.50);
		
		c.mostrarInfo();
		
		c.retirarCuenta(3435366, 100000);
		
		c.mostrarInfo();
		

	}

}
