import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploBD {

	
	static Connection conexion = null;
	static Statement stmt = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      try {
	    	//STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 3. Crear conexion
			System.out.println("Intentamos conectar");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Musicos?serverTimezone=UTC","root","123456");
			System.out.println("Nos hemos conectado");

			conexion.setAutoCommit(false);

			// 4 Crear Stametent
			stmt = conexion.createStatement();
			
			/*
			 * Crear base de datos, hay quye incluirla en la URL de conexion
			String SQL = "CREATE DATABASE Musicos";
			
			stmt.executeUpdate(SQL);
			*/
			
			/*
			 * Crear tabla
			 
			String SQL = "CREATE TABLE Grupo (" + 
					"Nombre VARCHAR(20) NOT NULL," + 
					"Genero VARCHAR(20)," + 
					"PRIMARY KEY (Nombre)" + 
					");";
			
			stmt.executeUpdate(SQL);
			*/
			
			/*
			 * A�adir datos
			String SQL = "INSERT INTO grupo(Nombre,Genero) VALUES(\"TWY\",\"Pop-punk\");";
			
			stmt.executeUpdate(SQL);
			*/
			
			/*Obtener datos*/
			String SQL = "Select * from grupo";
			ResultSet resultado = stmt.executeQuery(SQL);
			
			while(resultado.next()) {
				System.out.println(resultado.getString("Nombre"));
				System.out.println(resultado.getString("Genero"));
				conexion.rollback();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		
	}

}
