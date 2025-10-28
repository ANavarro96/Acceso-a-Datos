import java.sql.*;

public class EjemploMetaDatos {

        public static void main(String[] args) {
            // Establecer la conexión a la base de datos
            try (Connection conexion = ConexionDBSQLite.getConnection()) {

                // Obtener el objeto DatabaseMetaData a partir de la conexión
                DatabaseMetaData metaDatos = conexion.getMetaData();

                // Obtener e imprimir el nombre del driver y versión de la base de datos
               /* System.out.println("Driver Name: " + metaDatos.getDriverName());
                System.out.println("Driver Version: " + metaDatos.getDriverVersion());
                System.out.println("Nombre de la Base de Datos: " + metaDatos.getDatabaseProductName());
                System.out.println("Versión de la Base de Datos: " + metaDatos.getDatabaseProductVersion());*/

                // Obtener las tablas de la base de datos
                ResultSet tablas = metaDatos.getTables(null, null, "users",null);
                System.out.println("Estas son las tablas de la base de datos:");
                while (tablas.next()) {
                    String nombreTabla = tablas.getString("TABLE_NAME");
                    System.out.println("Tabla: " + nombreTabla);

                    ResultSet columnas = metaDatos.getColumns(null, null, nombreTabla, null);
                    System.out.println("Columnas en la tabla " + tablas.getString("TABLE_NAME"));
                    while (columnas.next()) {
                        System.out.println("Columna: " + columnas.getString("COLUMN_NAME") +
                                ", Tipo: " + columnas.getString("TYPE_NAME") +
                                ", Tamaño: " + columnas.getInt("COLUMN_SIZE"));
                    }

                    // Obtener las claves primarias de la tabla
                    ResultSet clavesPrimarias = metaDatos.getPrimaryKeys(null, null, nombreTabla);
                    System.out.println("Claves primarias de la tabla '" + nombreTabla + "':");
                    while (clavesPrimarias.next()) {
                        System.out.println("Columna: " + clavesPrimarias.getString("COLUMN_NAME") +
                               ", Nombre de la clave: " + clavesPrimarias.getString("PK_NAME"));
                    }

                    // Obtener las claves foráneas de la tabla
                    ResultSet clavesForaneas = metaDatos.getImportedKeys(null, null, nombreTabla);
                    //System.out.println("Claves foráneas de la tabla '" + nombreTabla + "':");
                    while (clavesForaneas.next()) {
                        System.out.println("Columna: " + clavesForaneas.getString("FKCOLUMN_NAME") +
                                ", Referencia a tabla: " + clavesForaneas.getString("PKTABLE_NAME") +
                                ", Columna referenciada: " + clavesForaneas.getString("PKCOLUMN_NAME") +
                                ", Nombre de la clave: " + clavesForaneas.getString("FK_NAME"));

                    }

                    // Obtener las columnas de una tabla específica

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

