import java.text.SimpleDateFormat;
import java.util.*;

class Cliente {
    private int codigo;
    private String nombre;
    private String apellido;
    private int estado;
    private List<Factura> facturas;

    public Cliente(int codigo, String nombre, String apellido, int estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.facturas = new ArrayList<>(); 
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public boolean esRegular() {
        int facturasValidas = 0;

        for (Factura factura : facturas) {
            if (factura.getTotal() > 15000) {
                facturasValidas++;
            }
        }

        return estado == 1 && facturasValidas >= 5;
    }
    public double obtenerTotalFacturas() {
    double totalSumado = 0;
    for (Factura factura : facturas) {
        totalSumado += factura.getTotal();
    }
    return totalSumado;
}

   public String toString() {
    return "Cliente: " + nombre + " " + apellido +
           "\nCódigo: " + codigo +
           "\nEstado: " + (estado == 1 ? "Activo" : "Inactivo") +
           "\nFacturas registradas: " + facturas.size() +
           "\n------------------------------";
    }
    public String obtenerFacturas() {
        if (facturas.isEmpty()) {
            return "No hay facturas registradas.";
        } else {
            StringBuilder sb = new StringBuilder();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            sb.append(String.format("%-10s %-15s %-20s%n", "Número", "Total", "Fecha"));
            sb.append("------------------------------------------------------\n");
            for (Factura factura : facturas) {
            String formatoTotal = String.format("$%,.2f", factura.getTotal());
            sb.append(String.format("%-10d %-15s %-20s%n",
                    factura.getNumero(),
                    formatoTotal,
                    //factura.getFecha().toString(),
                    formatoFecha.format(factura.getFecha())));
        }
                return sb.toString();
            }
        }
    }

