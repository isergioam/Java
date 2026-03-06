package BBDD;

import java.sql.*;

public class Update01_CambiarEdadPorId {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/academia?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        int id = 2;
        int nuevaEdad = 30;

        String sql = "UPDATE alumnos SET edad = ? WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nuevaEdad);
            ps.setInt(2, id);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                System.out.println("⚠️ No existe alumno con id=" + id + ". No se actualiza nada.");
            } else {
                System.out.println("✅ Edad actualizada. Filas afectadas: " + filas);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error SQL: " + e.getMessage());
        }
    }
}