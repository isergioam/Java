package BBDD;

import java.sql.*;

public class Delete01_BorrarPorId {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/academia?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        int id = 5;
        String sql = "DELETE FROM alumnos WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            System.out.println(filas == 1
                    ? "✅ Borrado OK (id=" + id + ")"
                    : "⚠️ No existía el alumno con id=" + id);

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }
    }
}