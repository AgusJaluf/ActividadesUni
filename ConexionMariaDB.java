import java.sql.Connection; // Importar la clase Connection QUE se utiliza para establecer la conexión con la base de datos
import java.sql.DriverManager; // Importar la clase DriverManager QUE se utiliza para gestionar las conexiones a la base de datos
import java.sql.SQLException; // Importar la clase SQLException QUE se utiliza para manejar errores relacionados con la base de datos
import java.sql.Statement; // Importar la clase Statement QUE se utiliza para ejecutar consultas SQL

// TODAS CLASES NATIVAS DE JAVA

// Esta clase establece una conexión con una base de datos MariaDB y ejecuta una consulta para crear una tabla
// MARIADB ES UN FORK DE MYSQL Y ES EL MOTOR QUE UTILIZA XAMPP
public class ConexionMariaDB {
    //ATRIBUTO ESTATICO FINAL QUE CONTIENE LA URL DE LA BASE DE DATOS
    // SE DECLARAN STATIC PORQUE LOS ATRIBUTOS PERTENECENA A LA CLASE Y NO A UN OBJETO EN PARTICULAR
    // SON FINAL PORQUE NO CAMBIAN EN TIEMPO DE EJECUCIÓN
    private static final String URL = "jdbc:mariadb://localhost:3306/tu_base_de_datos"; // URL de la base de datos MariaDB
    private static final String USUARIO = "tu_usuario"; // Nombre de usuario para la base de datos
    private static final String CONTRASENA = "tu_contrasena";  // Contraseña para la base de datos
    
    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() {
        // Intentar establecer la conexión con la base de datos
        try {
            /*  Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            NO ES NECESARIO CARGAR EL DRIVER MANUALMENTE EN LAS VERSIONES MAS NUEVAS DE JDBC
            */
        
            // CONEXIÓN A LA BASE DE DATOS CON LOS ATRIBUTOS ESTABLECIDOS
            // CONNECTION ES UNA INTERFAZ QUE SE UTILIZA PARA ESTABLECER UNA CONEXIÓN A LA BASE DE DATOS
            // ESTO SERIA SIMILAR A UN CONSTRUCTOR EN JAVA 
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexión establecida exitosamente.");
            return conexion;
        // MANEJO DE EXCEPCIONES
        // Si ocurre un error al intentar conectarse a la base de datos, se captura la excepción SQLException
        } catch (SQLException e) {
            System.err.println("Error al conectar con MariaDB: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Crear una conexión a la base de datos
        // Llamar al método obtenerConexion() para establecer la conexión
        Connection conexion = obtenerConexion();
        // Crear un objeto Statement para ejecutar consultas SQL
        Statement stmt = null;
        // Verificar si la conexión fue exitosa
        // Si la conexión no es nula, significa que se ha establecido correctamente
        if (conexion != null) {
            try {
                // Crear un objeto Statement para ejecutar consultas SQL
                stmt = conexion.createStatement();
                // Ejecutar una consulta SQL para crear una tabla llamada "usuarios" UTILIZANDO SENTENCIA SQL, A TRAVES DE UN OBJETO STATEMENT
                String sql = "CREATE TABLE IF NOT EXISTS usuarios (id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(50), edad INT)";
                // Ejecutar la consulta SQL
                stmt.executeUpdate(sql);
                System.out.println("Tabla creada o ya existente.");
            } catch (SQLException e) {
                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
            } finally {
                // Cerrar Statement 
                // Asegurarse de cerrar el Statement Y connection para liberar recursos
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        System.err.println("Error al cerrar Statement: " + e.getMessage());
                    }
                }
                // Cerrar la conexión
                try {
                    conexion.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}

// EJEMPLO DE USO CON TRY WITH RESOURCES
// Esto asegura que la conexión se cierre automáticamente al final del bloque try
// (no es necesario cerrar la conexión manualmente en el bloque finally)
/*
try (Connection conexion = obtenerConexion()) {
    if (conexion != null) {
        System.out.println("Conectado a MariaDB.");
        // Aquí ejecutarías consultas
    }
} catch (SQLException e) {
    System.err.println("Error de conexión: " + e.getMessage());
}
*/