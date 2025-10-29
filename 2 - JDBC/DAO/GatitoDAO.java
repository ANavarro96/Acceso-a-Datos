package DAO;

import DAO.Gato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GatitoDAO {

    /**
     * Inserta un nuevo gatito en la tabla 'gatitos'.
     * Usa los campos nombre y edad. El id es autoincremental.
     */
    public void insert(Gato gatito) throws SQLException {
        String sql = "INSERT INTO gatitos (nombre, edad) VALUES (?, ?)";

        try (Connection conn = ConexionDBSQLiteGatito.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, gatito.getNombre());
            pstmt.setInt(2, gatito.getEdad());

            pstmt.executeUpdate();
        }
    }

    /**
     * Devuelve todos los gatitos de la tabla.
     */
    public List<Gato> findAll() throws SQLException {
        String sql = "SELECT nombre, edad FROM gatitos";
        List<Gato> resultados = new ArrayList<>();

        try (Connection conn = ConexionDBSQLiteGatito.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                resultados.add(new Gato(nombre, edad));
            }
        }

        return resultados;
    }

    public boolean update(Gato datosNuevos) throws SQLException {
        String sql = "UPDATE gatitos SET  edad = ? WHERE nombre = ?,";

        try (Connection conn = ConexionDBSQLiteGatito.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(2, datosNuevos.getNombre());
            pstmt.setInt(1, datosNuevos.getEdad());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0; // true si existía ese id
        }
    }


    public boolean delete(Gato gatito) throws SQLException {
        String sql = "DELETE FROM gatitos WHERE nombre = ?";

        try (Connection conn = ConexionDBSQLiteGatito.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, gatito.getNombre());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }


    public Gato findById(String nombre) throws SQLException {
        String sql = "SELECT * FROM gatitos WHERE nombre = ?";

        try (Connection conn = ConexionDBSQLiteGatito.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombreLeido = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    return new Gato(nombreLeido, edad);
                } else {
                    return null; // no existe ese id
                }
            }
        }
    }
}
