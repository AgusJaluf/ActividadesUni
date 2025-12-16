import java.io.*; // Importamos las clases necesarias para manejar archivos

public class UsoArchivo {
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
        String nombreArchivo = "ejemplo.txt"; // Nombre del archivo a leer
        
        System.out.println("Contenido del archivo:");
        // Llamamos al método leerArchivo para leer el archivo
        leerArchivo(nombreArchivo);
    }
}

// puedo leer cualquier archivo txt, json, xml, etc, siempre que tengan texto plano, 
//si hay que extraer datos de un json o xml, hay que usar librerias como gson o jackson
// o librerias para xml como jaxb o dom4j
