import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploProcedimiento {

        public static void main(String[] args) {
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/musica";
            String user = "root";
            String password = "root";

            // The name of the genero to add
            String nombreGenero = "Comedia";

            Connection connection = null;
            CallableStatement callableStatement = null;

            try {
                // 1. Establish connection to the database
                connection = DriverManager.getConnection(url, user, password);

                // 2. Prepare the stored procedure call
                String sql = "{CALL ProcedimientoBorrar(?)}";
                callableStatement = connection.prepareCall(sql);

                // 3. Set the input parameter (nombreGenero)
                callableStatement.setString(1, "nombreGenero");  // 1 refers to the first parameter

                // 4. Execute the stored procedure
                //callableStatement.execute();

                System.out.println("Genero added successfully!");


                 sql = "{ ? = CALL obtenerMasCorta()}";
                callableStatement = connection.prepareCall(sql);

                callableStatement.registerOutParameter(1, java.sql.Types.VARCHAR);

                callableStatement.execute();
                String nombre = callableStatement.getString(1);
                System.out.println("La cancion más corta es " + nombre);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // 5. Clean up resources (close connections)
                try {
                    if (callableStatement != null) callableStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


