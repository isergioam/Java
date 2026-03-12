package com.paco.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.paco.hibernate.modelo.Alumno;
import com.paco.hibernate.modelo.Modulo;
import com.paco.hibernate.modelo.Profesor;
import com.paco.hibernate.util.HibernateUtil;

/**
 * Clase principal para probar que Hibernate funciona.
 */
public class Main {

    public static void main(String[] args) {

        // Abrimos una sesión con Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Iniciamos una transacción
        Transaction tx = session.beginTransaction();

        // Creamos un objeto Alumno en memoria
        //Alumno alumno = new Alumno(1, "Paco");
        Alumno a1 = new Alumno(3, "Andrés", 20);
        Alumno a2 = new Alumno(4, "Juan", 35);
        Alumno a3 = new Alumno(5, "Sandra", 18);
        Alumno a4 = new Alumno(6, "María", 23);
        Alumno a5 = new Alumno(7, "Pilar", 60);
        Alumno a6 = new Alumno(8, "Pilar", 30);
        Alumno a7 = new Alumno(9, "Pilar", 21);
        Profesor p1 = new Profesor(1, "Paco");
        Profesor p2 = new Profesor(2, "Santos");
        Profesor p3 = new Profesor(3, "Álvaro");
        Modulo m1 = new Modulo(1, "Base de Datos", 300);

        // Indicamos a Hibernate que queremos persistir este objeto
        //session.persist(p1);
        //session.persist(p2);
        //session.persist(p3);
        //session.persist(a1);
        //session.persist(a2);
        //session.persist(a3);
        //session.persist(a4);
        //session.persist(a5);
        //session.persist(a6);
        //session.persist(a7);
        //session.persist(m1);
        /* 
        // Buscamos un alumno por su clave primaria (id = 1)
        Alumno alumno = session.find(Alumno.class, 1);

        // Mostramos el resultado
        if (alumno != null) {
            System.out.println("Alumno encontrado: " + alumno);
        } else {
            System.out.println("No existe ningún alumno con ese id.");
        }*/        
      /*  
        // Consulta HQL para traer todos los alumnos
        List<Alumno> alumnos = session
                .createQuery("from Alumno", Alumno.class)
                .getResultList();

        // Recorremos la lista y mostramos cada alumno
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
        // Consulta HQL para traer todos los profesores
        List<Profesor> profesores = session
        		.createQuery("from Profesor", Profesor.class)
        		.getResultList();
        
        // Recorremos la lista y mostramos cada profesor
        for (Profesor a : profesores) {
        	System.out.println(a);
        }
        // Consulta HQL para traer todos los modulos
        List<Modulo> modulos = session
        		.createQuery("from Modulo", Modulo.class)
        		.getResultList();
        
        // Recorremos la lista y mostramos cada modulo
        for (Modulo a : modulos) {
        	System.out.println(a);
        }*/
        
        // Consulta HQL con condición
        List<Alumno> alumnos = session
                .createQuery("from Alumno where nombre = :nombre order by edad asc", Alumno.class)
                .setParameter("nombre", "Pilar")
                .getResultList();

        if (alumnos.isEmpty()) {
            System.out.println("No se encontraron alumnos con ese nombre.");
        } else {
            for (Alumno a : alumnos) {
                System.out.println(a.getNombre() + ", " + a.getEdad());
            }
        }

        // Confirmamos la transacción
        //tx.commit();

        // Cerramos la sesión
        session.close();

       // System.out.println("Profesores guardado correctamente.");
    }
}