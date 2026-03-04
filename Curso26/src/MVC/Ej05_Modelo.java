package MVC;

import java.util.ArrayList;

public class Ej05_Modelo {
	
	private ArrayList<Ej03_Modelo> alumnos = new ArrayList<>();
	private Ej04_Modelo curso;	
	
	public Ej05_Modelo(ArrayList<Ej03_Modelo> alumnos, Ej04_Modelo curso) {
		this.alumnos = alumnos;
		this.curso = curso;
	}
	
	public void add(Ej03_Modelo a) {
		alumnos.add(a);
	}
	
	public ArrayList<Ej03_Modelo> getAlumnos(){
		return alumnos;
	}
	public Ej04_Modelo getCurso(){
		return this.curso;
	}
	

}
