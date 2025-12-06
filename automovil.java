import java.util.Scanner;
import java.time.Year;

class Automovil {

    private static final int LIMITE_ANTIGUEDAD = 1990;

    private final String marca;
    private final int anioFabricacion;
    private final int velocidadMaxima;

    public Automovil(String marca, int anio, int velocidadMax) {
        this.marca = marca;
        this.anioFabricacion = anio;
        this.velocidadMaxima = velocidadMax;
    }

    public String encenderVehiculo() {
        if (this.anioFabricacion >= LIMITE_ANTIGUEDAD) {
            return "El " + this.marca + " se encendió con éxito.";
        } else {
            return "Falló el encendido. El vehículo es demasiado antiguo (Fabricación: " + this.anioFabricacion + ").";
        }
    }

    public int calcularAntiguedad(int anioActual) {
        if (anioActual < this.anioFabricacion) {
            return 0;
        }
        return anioActual - this.anioFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String marca;
        int anio;
        int velocidadMax;

        final int ANIO_ACTUAL = Year.now().getValue();

        System.out.println("Módulo: Datos de Vehículos");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese la marca del vehículo: ");
        marca = scanner.nextLine();

        System.out.print("Ingrese el año de fabricación: ");
        if (scanner.hasNextInt()) {
            anio = scanner.nextInt();
        } else {
            anio = 2010;
        }

        System.out.print("Ingrese la velocidad máxima (km/h): ");
        if (scanner.hasNextInt()) {
            velocidadMax = scanner.nextInt();
        } else {
            velocidadMax = 180;
        }
        scanner.close();

        Automovil miAuto = new Automovil(marca, anio, velocidadMax);

        System.out.println("\n--- Diagnóstico del Vehículo (" + miAuto.getMarca() + ") ---");

        String mensajeEncendido = miAuto.encenderVehiculo();
        System.out.println("Simulación de Encendido: " + mensajeEncendido);

        int antiguedad = miAuto.calcularAntiguedad(ANIO_ACTUAL);
        System.out.println("Antigüedad del vehículo: " + antiguedad + " años.");
    }
}