import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploTransacciones {
    static Connection conexion = null;
    static Statement stmt = null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. Crear conexion
            System.out.println("Intentamos conectar");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Musicos?serverTimezone=UTC", "root", "123456");
            System.out.println("Nos hemos conectado");

            conexion.setAutoCommit(false);

            // 4 Crear Stametent
            stmt = conexion.createStatement();

            String SQL = "INSERT INTO alumno(nombre,grupo) VALUES(\"Alejandro\",\"2DAM\");";

            stmt.executeUpdate(SQL);



            stmt.executeUpdate("UPDATE alumno set grupo = '3DAM' where nombreEW = 'Alejandro'");

            conexion.commit();





        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}