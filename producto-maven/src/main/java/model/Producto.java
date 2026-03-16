package model;

import jakarta.persistence.*;

/**
 * Entidad que representa un producto.
 */
@Entity
@Table(name = "productos")
public class Producto {

    /**
     * Clave primaria autogenerada.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del producto.
     */
    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Precio del producto.
     */
    @Column(nullable = false)
    private double precio;

    /**
     * Constructor vacío obligatorio para Hibernate.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros.
     */
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio + "}";
    }
}