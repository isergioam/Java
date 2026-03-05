package MVC_Banco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BancoVista {

	public void listarCuentas(ArrayList<Cuenta> cuentas) {
		for (Cuenta c : cuentas) {
			JOptionPane.showMessageDialog(null, "⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ Número de Cuenta: " + c.getNumeroCuenta() + "\n ✜ Titular: " + c.getTitular() + "\n ✜ Saldo: "
					+ c.getSaldo() + "€\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥", "Cuenta Banco", JOptionPane.CLOSED_OPTION);

		}

	}

	public void msjError(String m) {
		JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.ERROR_MESSAGE);
	}

}
