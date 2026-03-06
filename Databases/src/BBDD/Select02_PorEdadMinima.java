package BBDD;

import java.sql.*;

public class Select02_PorEdadMinima {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/academia?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        int edadMin = 18;
        String sql = "SELECT id, nombre, edad FROM alumnos WHERE edad >= ? ORDER BY edad DESC";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, edadMin);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("=== ALUMNOS CON EDAD >= " + edadMin + " ===");
                boolean hay = false;

                while (rs.next()) {
                    hay = true;
                    System.out.println(rs.getInt("id") + " - " + rs.getString("nombre") + " (" + rs.getInt("edad") + ")");
                }

                if (!hay) {
                    System.out.println("(Sin resultados)");
                }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }
    }
}
