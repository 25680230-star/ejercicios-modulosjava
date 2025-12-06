import java.util.Scanner;
import java.time.Year;

public class ArticuloBibliografico {

    private final String identificadorUnico;
    private final String nombreAutor;
    private boolean prestado;
    private final int anioPublicacion;

    public ArticuloBibliografico(String id, String autor, int anioPublicacion) {
        this.identificadorUnico = id;
        this.nombreAutor = autor;
        this.prestado = false;
        this.anioPublicacion = anioPublicacion;
    }

    public void reservar() {
        if (!this.prestado) {
            this.prestado = true;
            System.out.println("Artículo reservado con éxito.");
        } else {
            System.out.println("El artículo ya se encuentra prestado.");
        }
    }

    public boolean esAptoParaPrestamo() {
        int anioActual = Year.now().getValue();
        int antiguedad = anioActual - this.anioPublicacion;

        return antiguedad <= 5;
    }

    public String getIdentificadorUnico() {
        return identificadorUnico;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id, autor;
        int anio;
        int opcion = 0;

        System.out.println("📚 Módulo: Gestión de Libros");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese el identificador único: ");
        id = scanner.nextLine();

        System.out.print("Ingrese el nombre del autor: ");
        autor = scanner.nextLine();

        System.out.print("Ingrese el año de publicación: ");
        anio = scanner.hasNextInt() ? scanner.nextInt() : Year.now().getValue();
        scanner.nextLine();

        ArticuloBibliografico articulo = new ArticuloBibliografico(id, autor, anio);

        while (opcion != 3) {
            int antiguedad = Year.now().getValue() - articulo.getAnioPublicacion();

            System.out.println("\n--- Artículo: " + articulo.getIdentificadorUnico() + " ---");
            System.out.println("Autor: " + articulo.getNombreAutor());
            System.out.println("Publicación: " + articulo.getAnioPublicacion() + " (Antigüedad: " + antiguedad + " años)");
            System.out.println("Estado: " + (articulo.estaPrestado() ? "PRESTADO" : "DISPONIBLE"));

            String aptitud = articulo.esAptoParaPrestamo() ? "APTO (<= 5 años)" : "NO APTO (> 5 años)";
            System.out.println("Apto para Préstamo: " + aptitud);

            System.out.println("\n--- Menú de Operaciones ---");
            System.out.println("1. Simular Reserva");
            System.out.println("2. Forzar Antigüedad (Cambiar año de publicación)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        articulo.reservar();
                        break;
                    case 2:
                        System.out.print("Ingrese un nuevo año de publicación: ");
                        if (scanner.hasNextInt()) {
                            int nuevoAnio = scanner.nextInt();
                            // Recrear el objeto para actualizar la variable final anioPublicacion
                            articulo = new ArticuloBibliografico(id, autor, nuevoAnio);
                            System.out.println("Año de publicación forzado a " + nuevoAnio + ".");
                        } else {
                            System.out.println("Entrada no válida.");
                        }
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Saliendo del gestor bibliográfico.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Entrada no válida. Intente de nuevo.");
                scanner.nextLine();
                opcion = 0;
            }
        }
        scanner.close();
    }
}
