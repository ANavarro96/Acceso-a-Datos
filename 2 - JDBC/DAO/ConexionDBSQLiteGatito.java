package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDBSQLiteGatito {

    private static ConexionDBSQLiteGatito instance;
    private static Connection connection;


    private static final String URL = "jdbc:sqlite:gatitos.db";
    private ConexionDBSQLiteGatito() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to create the database connection.");
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConexionDBSQLiteGatito();
        }
        return connection;
    }
}
