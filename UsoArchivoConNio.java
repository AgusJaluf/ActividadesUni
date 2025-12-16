import java.nio.file.*; // Importamos las clases necesarias para trabajar con NIO
import java.io.*; // Importamos las clases necesarias para manejar archivos
import java.util.List;  // Importamos la clase List para manejar listas


public class UsoArchivoConNio {
     // metodo para leer un archivo
    public static void leerArchivo(String nombreArchivo) {
         // Usamos try-with-resources para cerrar automáticamente el escritor, que es una forma mejorada del metodo try en java
        // sin try-with-resources, el escritor no se cerraría automáticamente, se debe hacer manualmente
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            // BufferedReader para leer el archivo línea por línea
            // FileReader para leer el archivo
            String linea; // Variable para almacenar cada línea leída
            // Leemos el archivo línea por línea con un bucle while
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        // Si el archivo no existe, se lanza una excepción FileNotFoundException
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }



public static void main(String[] args) {
    // Definimos la ruta del archivo usando NIO
    // La clase Paths se utiliza para crear una ruta de archivo
    // permite trabajar con rutas de archivos de manera más flexible y portátil
    Path ruta = Paths.get("ejemplo.txt"); // Define la ruta del archivo

    try {
        // Leer todas las líneas del archivo y almacenarlas en una lista
        List<String> lineas = Files.readAllLines(ruta);
        // Imprimir el contenido línea por líne
        lineas.forEach(System.out::println);
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
   }
}

// puedo leer cualquier archivo txt, json, xml, etc, siempre que tengan texto plano, 
//si hay que extraer datos de un json o xml, hay que usar librerias como gson o jackson
// o librerias para xml como jaxb o dom4j

