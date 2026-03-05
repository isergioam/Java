package MVC_Almacen;

public class Main {

	public static void main(String[] args) {
		InventarioModelo modelo = new InventarioModelo();
		InventarioVista vista = new InventarioVista();
		InventarioController c = new InventarioController(modelo, vista);

		c.addProducto(1, "Tomate", 20.5, 30);
		c.addProducto(2, "Pimiento", 10.5, 50);
		c.addProducto(3, "Cebolla", 7.8, 6);

		//c.mostrarProducto(1);
		//c.mostrarProducto(2);
		//c.mostrarProducto(3);
		
		c.listarProductos();		
		
		c.actualizarStock(1, 70);
		
		c.eliminarProducto(1);
		
		c.actualizarPrecio(2, 20);
		
		
	
	
	}

}
