package Biblioteca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Biblioteca.modelo.Autor;
import Biblioteca.modelo.Libro;
import Biblioteca.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		Autor a1 = new Autor("Cervantes", "Española", 1547);
		Autor a2 = new Autor("J.K.Rowling", "Británica", 1965);
		Autor a3 = new Autor("J.R.R. Tolkien", "Británica", 1892);
		Autor a4 = new Autor("Stephen King", "Estadounidense", 1947);

		//session.persist(a1);
		//session.persist(a2);
		//session.persist(a3);
		//session.persist(a4);

		session.createMutationQuery("update Autor set anno_nacimiento = :anno where id = :id")
				.setParameter("anno", 1647).setParameter("id", 1).executeUpdate();

		List<Autor> autor = session.createQuery("from Autor", Autor.class).getResultList();
		for (Autor a : autor) {
			System.out.println(a);
		}

		tx.commit();
		session.close();
	}

}
