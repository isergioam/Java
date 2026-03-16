package dto;

public class ProductoDTO {

    private String nombre;
    private double precio;

    public ProductoDTO(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "ProductoDTO{nombre='" + nombre + "', precio=" + precio + "}";
    }
	
}
