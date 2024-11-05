import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // Step 1: Create a private static variable to hold the single instance of the class
    private static ConexionDB instance;
    private static Connection connection;

    // Database URL, username, and password should be adjusted according to your setup
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    private ConexionDB() throws SQLException {
        try {
            // Load JDBC driver (optional depending on the JDBC version)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Initialize the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to create the database connection.");
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConexionDB();
        }
        return connection;
    }
}
