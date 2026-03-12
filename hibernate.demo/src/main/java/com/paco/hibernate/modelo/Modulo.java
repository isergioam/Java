package com.paco.hibernate.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Modulo")
public class Modulo {

	@Id
	private int id;
	private String nombre;
	private int horas;

	public Modulo() {
		
	}
	
	public Modulo(int id, String nombre, int horas) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}
	
	

}
