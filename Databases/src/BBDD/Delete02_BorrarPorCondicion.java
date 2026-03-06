package BBDD;

import java.sql.*;

public class Delete02_BorrarPorCondicion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/academia?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        int edadLimite = 18;
        String sql = "DELETE FROM alumnos WHERE edad < ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, edadLimite);

            int filas = ps.executeUpdate();
            System.out.println("✅ Borrado por condición realizado. Filas afectadas: " + filas);

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }
    }
}