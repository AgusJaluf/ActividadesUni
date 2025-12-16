import java.io.*;
import java.util.*;

public class Main {
    private static final String BASE_PATH = "C:\\Users\\jime_\\Documents\\Java\\Trabajo en clases relaciones de clases\\TrabajoClaseG4_1\\TrabajoClaseG4_1\\src\\data\\";

    public static Map<String, Cliente> cargarClientes(String archivo) throws IOException {
        Map<String, Cliente> clientes = new HashMap<>();
        File file = new File(archivo);
        Scanner scanner = new Scanner(file);


        if (scanner.hasNextLine()) { //IGNORAR LA PRIMERA LINEA
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String[] datos = scanner.nextLine().split(";");
            clientes.put(datos[0], new Cliente(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3])));
        }

        scanner.close();
        return clientes;
    }

    public static void cargarFacturas(String archivo, Map<String, Cliente> clientes) throws IOException {
        File file = new File(archivo);
        Scanner scanner = new Scanner(file);

        
        if (scanner.hasNextLine()) {//IGNORAR LA PRIMERA LINEA
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String[] datos = scanner.nextLine().split(";");
            int numero = Integer.parseInt(datos[0]);
            int codigoCliente = Integer.parseInt(datos[1]);
            double total = Double.parseDouble(datos[2]);

            if (clientes.containsKey(String.valueOf(codigoCliente))) {
                // Asignar una fecha con GregorianCalendar
                Factura factura = new Factura(numero, total, 2025, 5, 12);
                clientes.get(String.valueOf(codigoCliente)).agregarFactura(factura);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        try {
            // Cargar clientes y facturas usando Scanner
            Map<String, Cliente> clientes = cargarClientes(BASE_PATH + "Clientes.txt");
            cargarFacturas(BASE_PATH + "Facturas.txt", clientes);

            // Mostrar clientes regulares con formato de `toString()`
            System.out.println("Clientes regulares:");

            for (Cliente cliente : clientes.values()) {
                if (cliente.esRegular()) {
                    System.out.println(cliente.toString());
                    System.out.println("Facturas Asociadas :");
                    System.out.println(cliente.obtenerFacturas());
                    System.out.println("------------------------------------------------------");
                    System.out.println("Total de todas sus facturas: $" + cliente.obtenerTotalFacturas());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer los archivos: " + e.getMessage());
        }
    }
}
