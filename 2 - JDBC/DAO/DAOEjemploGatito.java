package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEjemploGatito {

    public static void crearTablaGatito(Connection connection){
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS gatitos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "edad INTEGER NOT NULL" +
                ");";

        // Recordar el try-with-resources. Si no habría que cerrar el Statement.
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sqlCreateTable);
            System.out.println("Tabla 'gatitos' creada o ya existía.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla 'gatitos': " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        try {
            Connection conexionGato = ConexionDBSQLiteGatito.getConnection();
            crearTablaGatito(conexionGato);

            // TODO: Instanciar y crear el DAO de Gatito


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
