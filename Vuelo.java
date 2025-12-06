import java.util.Scanner;

public class Vuelo {

    private final String codigoVuelo;
    private final int capacidadMaxima;
    private int asientosReservados;

    public Vuelo(String codigo, int capacidad) {
        this.codigoVuelo = codigo;
        this.capacidadMaxima = capacidad;
        this.asientosReservados = 0;
    }

    public boolean realizarReserva(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (this.asientosReservados + cantidad <= this.capacidadMaxima) {
            this.asientosReservados += cantidad;
            return true;
        }
        return false;
    }

    public double calcularPorcentajeOcupacion() {
        return ((double) this.asientosReservados / this.capacidadMaxima) * 100.0;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getAsientosReservados() {
        return asientosReservados;
    }

    public static void main(String[] args) {
        Vuelo miVuelo = new Vuelo("LA500", 120);
        Scanner scanner = new Scanner(System.in);
        int cantidadReserva = 0;

        System.out.println("✈️ Sistema de Reservas Aéreas: Vuelo " + miVuelo.getCodigoVuelo());
        System.out.println("-------------------------------------");
        System.out.println("Capacidad Total: " + miVuelo.getCapacidadMaxima() + " asientos.");
        System.out.println("Actualmente reservados: " + miVuelo.getAsientosReservados());
        System.out.printf("Ocupación: %.2f%%\n", miVuelo.calcularPorcentajeOcupacion());
        System.out.println("-------------------------------------");

        // Única interacción: pedir la cantidad a reservar
        System.out.print("Ingrese el número de asientos que desea reservar: ");

        if (scanner.hasNextInt()) {
            cantidadReserva = scanner.nextInt();

            if (cantidadReserva > 0) {
                if (miVuelo.realizarReserva(cantidadReserva)) {
                    System.out.println("\n Reserva exitosa. Se reservaron " + cantidadReserva + " asientos.");
                } else {
                    int disponibles = miVuelo.getCapacidadMaxima() - miVuelo.getAsientosReservados();
                    System.out.println("\n Reserva fallida. Capacidad insuficiente.");
                    System.out.println("Máximo disponible para reservar: " + disponibles + " asientos.");
                }
            } else {
                System.out.println("⚠ Cantidad de asientos debe ser mayor que cero.");
            }
        } else {
            System.out.println(" Entrada no válida. Debe ingresar un número entero.");
        }

        scanner.close();

        // Mostrar Estado Final
        System.out.println("\n--- Estado Final del Vuelo ---");
        System.out.println("Total Asientos Reservados: " + miVuelo.getAsientosReservados() + " / " + miVuelo.getCapacidadMaxima());
        System.out.printf("Ocupación Final: %.2f%%\n", miVuelo.calcularPorcentajeOcupacion());
    }
}