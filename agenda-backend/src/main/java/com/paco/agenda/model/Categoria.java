package com.paco.agenda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta anotación indica que la clase es una entidad JPA
@Entity

// Nombre de la tabla en la base de datos
@Table(name = "categorias")
public class Categoria {

    // Clave primaria de la tabla
    @Id

    // Indica que el id se genera automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre de la categoría
    private String nombre;

    // Constructor vacío obligatorio para JPA
    public Categoria() {
    }

    // Constructor con parámetros
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    // Getter del id
    public Long getId() {
        return id;
    }

    // Setter del id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}