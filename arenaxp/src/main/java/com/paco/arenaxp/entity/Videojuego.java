package com.paco.arenaxp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Esta anotación indica que la clase es una entidad JPA.
@Entity

// Indicamos el nombre exacto de la tabla en la base de datos.
@Table(name = "videojuegos")
public class Videojuego {

    // Clave primaria de la tabla.
    @Id

    // El valor del id se generará automáticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo título.
    @Column(nullable = false, length = 150)
    private String titulo;

    // Campo plataforma.
    @Column(nullable = false, length = 100)
    private String plataforma;

    // Campo género.
    @Column(nullable = false, length = 100)
    private String genero;

    // Campo estado.
    @Column(nullable = false, length = 50)
    private String estado;

    // Campo puntuación.
    private Integer puntuacion;

    // Campo horas jugadas.
    @Column(name = "horas_jugadas")
    private Integer horasJugadas;

    // Campo favorito.
    private Boolean favorito;

    // Constructor vacío obligatorio para JPA.
    public Videojuego() {
    }

    // Getters y setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getHorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(Integer horasJugadas) {
        this.horasJugadas = horasJugadas;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
}