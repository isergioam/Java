package MVC;

import java.util.ArrayList;

public class Ej05_Modelo {
	
	private ArrayList<Ej03_Modelo> alumnos = new ArrayList<>();
	private String curso;	
	
	public void addEj(Ej03_Modelo a) {
		alumnos.add(a);
	}
	
	public void setAlumnos(ArrayList<Ej03_Modelo> alumnos) {
		this.alumnos = alumnos;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public ArrayList<Ej03_Modelo> getAlumnos(){
		return this.alumnos;
	}
	public String getCurso(){
		return this.curso;
	}

}
