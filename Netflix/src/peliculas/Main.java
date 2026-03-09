package peliculas;

import java.util.Scanner;
import java.util.ArrayList;
import peliculas.DAO.DAO;
import peliculas.model.*;

public class Main {

	public static void main(String[] args) {

		// MENÚ DE OPCIONES (LISTAR, BUSCAR, AÑADIR, ELIMINAR, ACTUALIZAR, SALIR)
		boolean salir = false;
		Scanner sc = new Scanner(System.in);

		while (!salir) {
			System.out.println("======== Menú ===========");
			System.out.println("1. Lista Películas");
			System.out.println("2. Buscar Películas");
			System.out.println("3. Añadir Pelicula");
			System.out.println("4. Borrar Pelicula");
			System.out.println("5. Actualizar Pelicula");
			System.out.println("0. Salir");
			System.out.println("=========================");

			int op = sc.nextInt();
			sc.nextLine();

			if (op == 0) { // SALIR
				System.out.println("Programa cerrado.");
				salir = true;
			}

			if (op == 1) { // LISTAR
				ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
				peliculas = DAO.listarPeliculas();
				for (PeliculasModel p : peliculas) {
					System.out.println(p);
				}
			}

			if (op == 2) { // BUSCAR
				ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
				System.out.println("Introduzca el nombre de la película:");
				String nombre = sc.nextLine();
				peliculas = DAO.buscarNombre(nombre);

				for (PeliculasModel p : peliculas) {
					System.out.println(p);
				}
			}

			if (op == 3) { // AÑADIR
				System.out.println("Introduzca el ID:");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca el titulo:");
				String titulo = sc.nextLine();

				System.out.println("Introduzca el año:");
				int anno = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca la duración:");
				int duracion = sc.nextInt();
				sc.nextLine();

				DAO.insertarPelicula(id, titulo, anno, duracion);

			}

			if (op == 4) { // ELIMINAR
				System.out.println("Introduzca el ID de la película que va eliminar:");
				int id = sc.nextInt();
				sc.nextLine();
				DAO.borrarPelicula(id);
			}

			if (op == 5) { // ACTUALIZAR
				System.out.println("Introduzca el ID de la película que quiere modificar:");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca el nuevo titulo:");
				String titulo = sc.nextLine();

				System.out.println("Introduzca el nuevo año de estreno:");
				int anno = sc.nextInt();
				sc.nextLine();

				System.out.println("Introduzca la nueva duración:");
				int duracion = sc.nextInt();
				sc.nextLine();

				DAO.actualizarPelicula(id, titulo, anno, duracion);

			}

		}
		sc.close();

		// FIN MENÚ

		/*
		 * // EJERCICIOS ANTIGUOS // LISTAR TODAS ArrayList<PeliculasModel> peliculas =
		 * new ArrayList<PeliculasModel>(); peliculas = DAO.listarPeliculas();
		 * 
		 * for (PeliculasModel p : peliculas) { System.out.println(p); }
		 * 
		 * // PELICULAS DEL AÑO 1990 ArrayList<PeliculasModel> peliculasAnno = new
		 * ArrayList<PeliculasModel>(); peliculasAnno = DAO.listarAnno(2001);
		 * 
		 * for (PeliculasModel p : peliculasAnno) { System.out.println(p); }
		 * 
		 * // BUSCAR PELICULA POR NOMBRE ArrayList<PeliculasModel> peliculasNombre = new
		 * ArrayList<PeliculasModel>(); peliculasNombre = DAO.buscarNombre("Star Wars");
		 * 
		 * for (PeliculasModel p : peliculasNombre) { System.out.println(p); }
		 * 
		 * // PELICULA ORDENADA POR AÑO ArrayList<PeliculasModel> peliculasOrden = new
		 * ArrayList<PeliculasModel>(); peliculasOrden = DAO.peliculasOrden("DESC");
		 * 
		 * for (PeliculasModel p : peliculasOrden) { System.out.println(p); }
		 */
	}

}
