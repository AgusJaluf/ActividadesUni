public class Trabajador {
    private String nombre;
    private String dni;
    private String telefono;
    private String categoriaIVA;

    // Constructor
    public Trabajador(String nombre, String dni, String telefono, String categoriaIVA) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.categoriaIVA = categoriaIVA;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCategoriaIVA() {
        return categoriaIVA;
    }

    public void setCategoriaIVA(String categoriaIVA) {
        this.categoriaIVA = categoriaIVA;
    }

    // Método para determinar la letra de la factura
    public String obtenerLetraFactura() {
        switch (categoriaIVA) {
            case "RESPONSABLE INSCRIPTO":
                return "A";
            case "MONOTRIBUTO":
                return "A";
            case "CONSUMIDOR FINAL":
                return "B";
            case "EXENTO":
                return "B";
            default:
                return "Categoría IVA inválida";
        }
    }
}
