package MVC_Agenda;

public class Main {

	public static void main(String[] args) {
		AgendaModel agenda = new AgendaModel();
		AgendaVista vista = new AgendaVista();
		AgendaControlador controlador = new AgendaControlador(agenda, vista);

		controlador.addAgenda("Sergio", "Aguilar", "666555222", "sergio@sergio.com");
		controlador.addAgenda("Francisco", "Pala", "666555222", "paco@paco.com");
		
		controlador.mostrarAgenda();

	}

}
