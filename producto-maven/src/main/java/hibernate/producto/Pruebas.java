package hibernate.producto;

//import model.Producto;
import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.ProductoDTO;

/**
 * Ejemplo para mostrar cómo funciona rollback en Hibernate.
 */
public class Pruebas {

    public static void main(String[] args) {

        Session session = null;
        Transaction tx = null;

        try {
        	System.out.println("Sesión abierta.");
            // Abrimos sesión
            session = HibernateUtil.getSessionFactory().openSession();

            // Iniciamos la transacción
            tx = session.beginTransaction();
            
            String hql = "select new dto.ProductoDTO(p.nombre, p.precio) from Producto p";
            List<ProductoDTO> lista = session.createQuery(hql, ProductoDTO.class).getResultList();

            
            for(ProductoDTO l : lista) {
            	System.out.println(l);
            }
            
            /*
            // Creamos un producto válido
            Producto p1 = new Producto("Teclado mecánico", 59.99, 30, "Teclado para ordenador.");

            // Guardamos el primer producto
            session.persist(p1);

            // Creamos un producto con un dato inválido
            Producto p2 = new Producto("Ratón gaming", 20, 100, "Raton para ordenador.");

            // Validación de negocio:
            // si el precio es negativo, lanzamos una excepción
            if (p2.getPrecio() < 0) {
                throw new RuntimeException("El precio no puede ser negativo");
            }

            // Esta línea no llegará a ejecutarse si el precio es negativo
            session.persist(p2);*/

            // Si todo ha ido bien, confirmamos los cambios
            tx.commit();

            System.out.println("Transacción completada correctamente.");

        } catch (Exception e) {

            System.out.println("Se ha producido un error: " + e.getMessage());

            // Si la transacción existe, deshacemos los cambios
            if (tx != null) {
                tx.rollback();
                System.out.println("Se ha hecho rollback de la transacción.");
            }

        } finally {

            // Cerramos la sesión
            if (session != null) {
                session.close();
            }

            System.out.println("Sesión cerrada.");
        }
    }
}