package MVC_Agenda;

import java.util.ArrayList;

public class AgendaControlador {
	private AgendaModel agenda;
	private AgendaVista vista;
	
	public AgendaControlador(AgendaModel agenda, AgendaVista vista) {
		this.agenda = agenda;
		this.vista = vista;
	}

	
	public void addAgenda(String nombre, String apellidos, String telefono, String email) {
		Contacto c = new Contacto(nombre, apellidos, telefono, email);
		agenda.add(c);
		
	}
	
	public void mostrarAgenda() {
		ArrayList<Contacto> contactos = agenda.getContactos();
		vista.mostrarListado(contactos);
	}
	
}
