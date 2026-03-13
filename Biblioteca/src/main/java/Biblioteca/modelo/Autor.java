package Biblioteca.modelo;

import jakarta.persistence.*;

@Entity

@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, length = 100)
	private String nombre;
	@Column(length = 50)
	private String nacionalidad;

	private int anno_nacimiento;

	public Autor() {

	}

	public Autor(String nombre, String nacionalidad, int anno_nacimiento) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.anno_nacimiento = anno_nacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getAnno_nacimiento() {
		return anno_nacimiento;
	}

	public void setAnno_nacimiento(int anno_nacimiento) {
		this.anno_nacimiento = anno_nacimiento;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", anno_nacimiento="
				+ anno_nacimiento + "]";
	}

	
}
