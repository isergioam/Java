package POO;

import java.util.ArrayList;

// Cliente
class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
}

// Producto
class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + this.nombre + ", Precio: $" + this.precio);
    }

}

// Pedido
// Tiene un cliente y una lista de productos
class Pedido {
    Cliente cliente;
    ArrayList<Producto> listaProductos = new ArrayList<>();

    public Pedido(Cliente c) {
        this.cliente = c;
    }

    public void comprarProducto(Producto p) {
        this.listaProductos.add(p);
    }

    public void total() {
        double total = 0;
        for (Producto producto : this.listaProductos) {
            total += producto.precio;
        }
        System.out.println("Total: " + total);
    }

    public void listaCompra() {
        for (Producto producto : this.listaProductos) {
            producto.mostrarInfo();
        }
    }
}

public class Ejer013 {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Paco");

        Producto p1 = new Producto("Camiseta", 19.99);
        Producto p2 = new Producto("Pantalón", 39.99);
        Producto p3 = new Producto("Zapatos", 59.99);

        Pedido pedido = new Pedido(cliente);
        pedido.comprarProducto(p1);
        pedido.comprarProducto(p2);
        pedido.comprarProducto(p3);

        System.out.println("Cliente: " + cliente.nombre);
        System.out.println("Lista de productos comprados:");
        pedido.listaCompra();
        pedido.total();

    }

}
