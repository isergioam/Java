package peliculas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import peliculas.DB.DB;
import peliculas.model.PeliculasModel;

public class DAO {
	// Mapeo filas rs y las convierto en objetos PeliculasModel
	public static PeliculasModel mapeo(ResultSet rs) throws SQLException {
		return new PeliculasModel(rs.getInt("id"), rs.getString("titulo"), rs.getInt("anno_estreno"),
				rs.getInt("duracion"));
	}

	// listas peliculas	
	public static ArrayList<PeliculasModel> listarPeliculas() {
		String sql = "SELECT id, titulo, anno_estreno, duracion FROM peliculas";
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();

		try (Connection con = DB.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				peliculas.add(DAO.mapeo(rs));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return peliculas;
	}

	// Lista por año
	public static ArrayList<PeliculasModel> listarAnno(int anno) {
		String sql = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE anno_estreno = ?";
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, anno);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;
	}

	// Buscar pelicula por nombre
	public static ArrayList<PeliculasModel> buscarNombre(String titulo) {
		String sql = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE titulo LIKE ?";

		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();
		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, "%" + titulo + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;

	}

	// Peliculas ordenadas por año
	public static ArrayList<PeliculasModel> peliculasOrden(String orden) {
		ArrayList<PeliculasModel> peliculas = new ArrayList<PeliculasModel>();

		if (!orden.equals("ASC") && !orden.equals("DESC")) {
			return peliculas;
		}

		String sql = "SELECT id, titulo, anno_estreno, duracion FROM peliculas WHERE titulo ORDER BY anno_estreno "
				+ orden;

		try (Connection con = DB.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, orden);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					peliculas.add(DAO.mapeo(rs));
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return peliculas;

	}
	
	public static boolean insertarPelicula(int id, String titulo, int anno_estreno, int duracion) {
		
		String sql = "INSERT INTO Netflix.peliculas (id, titulo, anno_estreno, duracion) VALUES (?,?,?,?)";
		
	    try (Connection cn = DB.getConnection();
	            PreparedStatement ps = cn.prepareStatement(sql)) {

	           ps.setInt(1, id);
	           ps.setString(2, titulo);
	           ps.setInt(3, anno_estreno);
	           ps.setInt(4, duracion);

	          
	           return ps.executeUpdate() == 1;

	       } catch (SQLException e) {
	    	   System.out.println(e.getMessage());
	           return false;
	       }
	
	
	}
	
	public static boolean borrarPelicula(int id) {
		
		String sql = "DELETE FROM Netflix.peliculas WHERE id = ?";
		
	    try (Connection cn = DB.getConnection();
	            PreparedStatement ps = cn.prepareStatement(sql)) {

	           ps.setInt(1, id);	          
	           return ps.executeUpdate() == 1;

	       } catch (SQLException e) {
	    	   System.out.println(e.getMessage());
	           return false;
	       }
	
	
	}
	
	public static boolean actualizarPelicula(int id, String titulo, int anno_estreno, int duracion) {
		
		String sql = "UPDATE Netflix.peliculas SET titulo=?, anno_estreno=?, duracion=? WHERE id=?";
		
	    try (Connection cn = DB.getConnection();
	            PreparedStatement ps = cn.prepareStatement(sql)) {
          
	           ps.setString(1, titulo);	          
	           ps.setInt(2, anno_estreno);	          
	           ps.setInt(3, duracion);
	           ps.setInt(4, id);
	           
	           return ps.executeUpdate() == 1;

	       } catch (SQLException e) {
	    	   System.out.println(e.getMessage());
	           return false;
	       }
	
	
	}

}
