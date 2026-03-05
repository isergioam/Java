package MVC_Almacen;

import java.util.ArrayList;

public class InventarioController {
	private InventarioModelo modelo;
	private InventarioVista vista;

	public InventarioController(InventarioModelo modelo, InventarioVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void addProducto(int codigo, String nombre, double precio, int stock) {
		if (nombre.equals(null) || nombre.isBlank() || nombre.isEmpty()) {
			vista.msjError("El producto debe contener un nombre válido.");
			return;
		}

		if (codigo <= 0 || precio <= 0 || stock <= 0) {
			vista.msjError("La cantidad debe ser positiva y mayor que cero.");
			return;
		}

		if (buscarProducto(codigo) != null) {
			vista.msjError("Ya existe un producto con ese código.");
		}

		Producto p = new Producto(codigo, nombre, precio, stock);
		modelo.addProducto(p);
	}

	public void listarProductos() {
		ArrayList<Producto> productos = modelo.getProductos();
		vista.mostrarLista(productos);
	}

	public Producto buscarProducto(int codigo) {

		for (Producto p : modelo.getProductos()) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		return null;
	}

	public Producto mostrarProducto(int codigo) {
		for (Producto p : modelo.getProductos()) {
			if (p.getCodigo() == codigo) {
				vista.mostrarProducto(p);
			}
		}
		return null;
	}

	public void actualizarStock(int codigo, int stock) {
		Producto p = buscarProducto(codigo);
		int nuevoStock = p.getStock() + stock;

		p.setStock(nuevoStock);
	}
	
	public void eliminarProducto(int codigo) {
		Producto p = buscarProducto(codigo);
		modelo.getProductos().remove(p);		
	}
	
	public void actualizarPrecio(int codigo, double precioNuevo) {
		Producto p = buscarProducto(codigo);
		p.setPrecio(precioNuevo);
	}

}
