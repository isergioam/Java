package com.paco.agenda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Esta clase representa la tabla de contactos
@Entity
@Table(name = "contactos")
public class Contacto {

    // Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del contacto
    private String nombre;

    // Apellidos del contacto
    private String apellidos;

    // Indica si el contacto es favorito
    private Boolean favorito;

    // Muchos contactos pueden pertenecer a una misma categoría
    @ManyToOne

    // Nombre de la columna de clave foránea
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Constructor vacío obligatorio para JPA
    public Contacto() {
    }

    // Constructor con parámetros
    public Contacto(String nombre, String apellidos, Boolean favorito, Categoria categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.favorito = favorito;
        this.categoria = categoria;
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

    // Getter de apellidos
    public String getApellidos() {
        return apellidos;
    }

    // Setter de apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter de favorito
    public Boolean getFavorito() {
        return favorito;
    }

    // Setter de favorito
    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    // Getter de categoria
    public Categoria getCategoria() {
        return categoria;
    }

    // Setter de categoria
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}