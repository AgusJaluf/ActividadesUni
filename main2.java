import java.util.ArrayList;

public class main {

    public class Cine {
        private String nombre;
        private String direccion;
        private ArrayList<Pelicula> peliculas;
        private ArrayList<Usuario> usuarios;

        public Cine(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.peliculas = new ArrayList<>();
            this.usuarios = new ArrayList<>();
        }

        public void agregarPelicula(Pelicula pelicula) {
            peliculas.add(pelicula);
        }

        public void agregarUsuario(Usuario usuario) {
            usuarios.add(usuario);
        }

        public ArrayList<Pelicula> getPeliculas() {
            return peliculas;
        }

        public ArrayList<Usuario> getUsuarios() {
            return usuarios;
        }
    }
    
    public class Pelicula {
        private String nombre;
        private String genero;
        private int duracion; // en minutos
        private boolean peliculaDeLaSemana;
        private double precio; // precio de la película

        public Pelicula(String nombre, String genero, int duracion, double precio) {
            this.nombre = nombre;
            this.genero = genero;
            this.duracion = duracion;
            this.peliculaDeLaSemana = false; // por defecto no es película de la semana
            this.precio = precio; // precio de la película
        }

        public String getNombre() {
            return nombre;
        }

        public String getGenero() {
            return genero;
        }

        public int getDuracion() {
            return duracion;
        }

        public double getPrecio() {
            return precio;
        }

        public boolean isPeliculaDeLaSemana() {
            return peliculaDeLaSemana;
        }

        public void setPeliculaDeLaSemana() {
            this.peliculaDeLaSemana = !peliculaDeLaSemana; // Cambia el estado de película de la semana
        }        
    }

    public class Usuario {
        private String nombre;
        private String email;
        private int edad;
        private boolean isDiscapacitado;
        private int dosXUno; // contador de entradas 2x1

        public Usuario(String nombre, String email, int edad, boolean isDiscapacitado) {
            this.nombre = nombre;
            this.email = email;
            this.edad = edad;
            this.isDiscapacitado = isDiscapacitado; // por defecto no es discapacitado
            this.dosXUno = 0; // contador de entradas 2x1 inicializado a 0
        }

        public String getNombre() {
            return nombre;
        }

        public String getEmail() {
            return email;
        }

        public int getEdad() {
            return edad;
        }

        public boolean isDiscapacitado() {
            return isDiscapacitado;
        }

        public int getDosXUno() {
            return dosXUno;
        }

        public void aumentarDosXUno() {
            this.dosXUno = dosXUno + 1; // Aumenta el contador de entradas 2x1
        }

        public void restarDosXUno() {
            if (dosXUno > 0) {
                this.dosXUno = dosXUno - 1; // Disminuye el contador de entradas 2x1
            } else {
                System.out.println("No tienes entradas 2x1 disponibles.");
            }
        }


        public ArrayList<Pelicula> getPeliculas(Cine cine) {
            return cine.getPeliculas(); // Devuelve la lista de películas del cine
        }

        public void comprarEntrada(Pelicula pelicula) {
            // Aquí se implementaría la lógica para comprar una entrada
            // Por ejemplo, verificar disponibilidad, procesar el pago, etc.
            double precio = pelicula.getPrecio(); // Obtener el precio de la película
            double descuento = 0.0; // Inicializar descuento
            if (isDiscapacitado) {
                descuento = 0.0; // 100% de descuento para discapacitados
                System.out.println("Descuento del 100% aplicado por ser discapacitado.");
            } else if (edad > 65) {
                descuento = 0.5; // 50% de descuento para mayores de 65 años
                System.out.println("Descuento del 50% aplicado por ser mayor de 65 años.");
            } else if (dosXUno > 0) {
                descuento = 0.5; // 50% de descuento si tiene entradas 2x1
                restarDosXUno();
                System.out.println("Entrada 2x1 utilizada. Te quedan " + dosXUno + " entradas 2x1.");
            } else if (pelicula.isPeliculaDeLaSemana()) {
                descuento = 0.6; // 40% de descuento si es película de la semana
                System.out.println("Descuento del 40% aplicado por ser película de la semana.");
            } else {
                descuento = 1; // Sin descuento
            }

            precio = precio * descuento; // Aplicar descuento al precio
            System.out.println("Precio de la entrada: " + precio); // Mostrar precio final


            System.out.println("Entrada comprada para la película: " + pelicula.getNombre());

            System.out.println("Nombre del usuario: " + nombre);
            System.out.println("Email del usuario: " + email);
            System.out.println("Edad del usuario: " + edad);

            System.out.println("Que lo disfrutes!"); // Mensaje de despedida
            System.out.println("--------------------------------------------------");
        }
        
    }

    public static void main(String[] args) {
        // Crear un cine
        Cine cine = new main().new Cine("Cineplex", "123 Main St");

        // Crear algunas películas
        Pelicula pelicula1 = new main().new Pelicula("Avengers", "Acción", 120, 10.0);
        Pelicula pelicula2 = new main().new Pelicula("Frozen", "Animación", 90, 8.0);
        Pelicula pelicula3 = new main().new Pelicula("Inception", "Ciencia Ficción", 148, 12.0);

        // Agregar películas al cine
        cine.agregarPelicula(pelicula1);
        cine.agregarPelicula(pelicula2);
        cine.agregarPelicula(pelicula3);

        // Crear algunos usuarios
        Usuario usuario1 = new main().new Usuario("Juan", "juan@hotmail.com", 30, false);
        Usuario usuario2 = new main().new Usuario("Ana", "ana@gmail.com", 70, false);
        Usuario usuario3 = new main().new Usuario("Luis", "luis@gmail.com", 25, true);
        Usuario usuario4 = new main().new Usuario("Maria", "maria@gmail.com", 40, false);

        // Agregar usuarios al cine
        cine.agregarUsuario(usuario1);
        cine.agregarUsuario(usuario2);
        cine.agregarUsuario(usuario3);
        cine.agregarUsuario(usuario4);

        // Agregar algunos DosXUno a los usuarios
        usuario1.aumentarDosXUno(); // Juan tiene 1 entrada 2x1
        usuario2.aumentarDosXUno(); // Ana tiene 1 entrada 2x1

        // El usuario1 lista las películas disponibles
        System.out.println("Películas disponibles en el cine:");
        for (Pelicula pelicula : cine.getPeliculas()) {
            System.out.println("- " + pelicula.getNombre() + " (" + pelicula.getGenero() + ") - Duración: " + pelicula.getDuracion() + " minutos - Precio: $" + pelicula.getPrecio());
        }
        System.out.println("--------------------------------------------------");


        // Comprar entradas Avengers
        usuario1.comprarEntrada(pelicula1); // Juan compra una entrada para Avengers
        usuario2.comprarEntrada(pelicula1); // Ana compra una entrada para Avengers
        usuario3.comprarEntrada(pelicula1); // Luis compra una entrada para Avengers
        usuario4.comprarEntrada(pelicula1); // Maria compra una entrada para Avengers
        
        // Comprar entradas Frozen
        usuario1.comprarEntrada(pelicula2); // Juan compra una entrada para Frozen
        usuario2.comprarEntrada(pelicula2); // Ana compra una entrada para Frozen
        usuario3.comprarEntrada(pelicula2); // Luis compra una entrada para Frozen
        usuario4.comprarEntrada(pelicula2); // Maria compra una entrada para Frozen


    
    }

}
