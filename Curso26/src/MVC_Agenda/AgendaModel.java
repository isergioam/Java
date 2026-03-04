package MVC_Agenda;

import java.util.ArrayList;

public class AgendaModel {

	ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	
	public void add(Contacto c) {
		contactos.add(c);
	}
	
	public ArrayList<Contacto> getContactos(){
		return contactos;
	}
	
}
