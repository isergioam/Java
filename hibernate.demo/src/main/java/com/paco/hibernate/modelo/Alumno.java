package com.paco.hibernate.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * La anotación @Entity indica que esta clase será gestionada por Hibernate
 * y que representa una tabla de la base de datos.
 */
@Entity

/**
 * La anotación @Table permite indicar el nombre de la tabla.
 */
@Table(name = "alumnos")
public class Alumno {

    /**
     * @Id marca la clave primaria de la entidad.
     */
    @Id
    private int id;

    /**
     * Campo normal de la entidad.
     */
    private String nombre;
    
    
    private int edad;

    /**
     * Constructor vacío obligatorio para Hibernate.
     * Hibernate necesita poder crear objetos sin pasar parámetros.
     */
    public Alumno() {
    }

    /**
     * Constructor con parámetros para facilitar la creación de objetos.
     */
    public Alumno(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Getter del id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
    	return edad;
    }
    
    public void setEdad(int edad) {
    	this.edad = edad;
    }

    /**
     * Método toString para mostrar el objeto cómodamente.
     */
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

   

}