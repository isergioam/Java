package MVC_Almacen;

import java.util.ArrayList;

public class InventarioModelo {
	ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public void addProducto(Producto p) {
		productos.add(p);
	}
	
	public ArrayList<Producto> getProductos(){
		return productos;
	}
	

}
