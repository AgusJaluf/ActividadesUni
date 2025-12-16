import java.util.Date;
import java.util.GregorianCalendar;

class Factura {
    private int numero;
    private double total;
    private Date fecha;

    public Factura(int numero, double total, int anio, int mes, int dia) {
        this.numero = numero;
        this.total = total;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia); 
        this.fecha = calendario.getTime();
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;

    }
    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero=" + numero +
                ", total=" + total +
                ", fecha=" + fecha +
                '}';
    }
}
