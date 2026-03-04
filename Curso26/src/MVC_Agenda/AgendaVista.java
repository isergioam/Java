package MVC_Agenda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgendaVista {

	public void mostrarListado(ArrayList<Contacto> contacto) {

		for (int i = 0; i < contacto.size(); i++) {
			Contacto c = contacto.get(i);
			JOptionPane.showMessageDialog(null,
					"⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥\n ✜ Nombre: " + c.getNombre() + "\n ✜ Apellidos: " + c.getApellidos()
							+ "\n ✜ Email: " + c.getEmail() + "\n ✜ Teléfono: " + c.getTelefono()
							+ "\n⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥⛥",
					"AGENDA", JOptionPane.CLOSED_OPTION);
		}

	}

}
