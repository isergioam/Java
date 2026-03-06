package BBDD;

import java.sql.*;

public class Update02_IncrementarEdadPorCondicion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/academia?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        int umbral = 18;
        String sql = "UPDATE alumnos SET edad = edad + 1 WHERE edad < ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, umbral);

            int filas = ps.executeUpdate();
            System.out.println("✅ Actualización masiva hecha. Filas afectadas: " + filas);

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }
    }
}