import java.sql.*;

public class SQLite {

    // SQLite connection string
    private static final String URL = "jdbc:sqlite:sample.db";  // It will create "sample.db" if it doesn't exist

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Step 1: Establish the connection to SQLite database
            connection = DriverManager.getConnection(URL);
            connection = ConexionDBSQLite.getConnection();
            if (connection != null) {
                System.out.println("Connection to SQLite has been established.");

                // Step 2: Create a table
                createNewTable(connection);

                // Step 3: Insert data into the table
                insertData(connection, "John Doe", 28);
                insertData(connection, "Jane Doe", 32);

                // Step 4: Select and display data
                selectAll(connection);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 5: Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Create a new table in the database
    private static void createNewTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL, age INTEGER)";

        try (Statement stmt = connection.createStatement()) {
            // Execute the table creation
            stmt.execute(createTableSQL);
            System.out.println("Table 'users' created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Insert a new row into the users table
    private static void insertData(Connection connection, String name, int age) {
        String insertSQL = "INSERT INTO users(name, age) VALUES('" + name + "', " + age + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(insertSQL);
            System.out.println("Inserted user: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Select and display all rows in the users table
    private static void selectAll(Connection connection) {
        String selectSQL = "SELECT id, name, age FROM users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

