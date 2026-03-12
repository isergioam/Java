package com.paco.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para crear y reutilizar una única SessionFactory.
 */
public class HibernateUtil {

    /**
     * SessionFactory es un objeto pesado de crear,
     * así que lo normal es construirlo una sola vez.
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Método privado que construye la SessionFactory
     * a partir del archivo hibernate.cfg.xml.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Lee la configuración por defecto desde hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear SessionFactory: " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Devuelve la SessionFactory para usarla desde otras clases.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}