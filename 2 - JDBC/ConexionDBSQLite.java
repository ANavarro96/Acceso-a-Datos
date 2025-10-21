import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDBSQLite {

    private static ConexionDBSQLite instance;
    private static Connection connection;


    private static final String URL = "jdbc:sqlite:sample.db";
    private ConexionDBSQLite() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to create the database connection.");
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConexionDBSQLite();
        }
        return connection;
    }
}
