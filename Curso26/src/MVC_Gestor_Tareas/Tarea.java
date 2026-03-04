package MVC_Gestor_Tareas;

public class Tarea {

	private String titulo;
	private boolean hecha;

	public Tarea(String titulo) {
		this.titulo = titulo;
		this.hecha = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isHecha() {
		return hecha;
	}

	public void setHecha(boolean hecha) {
		this.hecha = hecha;
	}

}
