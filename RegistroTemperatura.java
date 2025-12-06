import java.time.LocalDate;
import java.util.Scanner;

public class RegistroTemperatura {

    private static final double LIMITE_EXTREMO_CELSIUS = 40.0;

    private double valorTemperatura;
    private String unidadMedida;
    private final LocalDate fechaRegistro;

    public RegistroTemperatura(double valor, String unidad, LocalDate fecha) {
        this.valorTemperatura = valor;
        this.unidadMedida = unidad.toUpperCase();
        this.fechaRegistro = fecha;
    }

    public void convertirTemperatura() {
        if (this.unidadMedida.equals("C")) {
            this.valorTemperatura = (this.valorTemperatura * 9.0 / 5.0) + 32.0;
            this.unidadMedida = "F";
        } else if (this.unidadMedida.equals("F")) {
            this.valorTemperatura = (this.valorTemperatura - 32.0) * 5.0 / 9.0;
            this.unidadMedida = "C";
        }
    }

    public boolean esTemperaturaExtrema() {
        double valorEnCelsius = this.valorTemperatura;

        if (this.unidadMedida.equals("F")) {
            valorEnCelsius = (this.valorTemperatura - 32.0) * 5.0 / 9.0;
        }

        return valorEnCelsius > LIMITE_EXTREMO_CELSIUS;
    }

    public double getValorTemperatura() {
        return valorTemperatura;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valor;
        String unidad;

        System.out.println("🌡 Módulo: Registro de Temperatura ☀️");



        System.out.print("Ingrese el valor de la temperatura (ej: 38.5): ");
        if (scanner.hasNextDouble()) {
            valor = scanner.nextDouble();
            scanner.nextLine();
        } else {
            System.out.println(" Entrada de valor no válida. Usando 25.0 por defecto.");
            valor = 25.0;
            scanner.nextLine();
        }


        System.out.print("Ingrese la unidad (C para Celsius o F para Fahrenheit): ");
        unidad = scanner.nextLine().trim().toUpperCase();

        if (!unidad.equals("C") && !unidad.equals("F")) {
            System.out.println(" Unidad no reconocida. Usando C por defecto.");
            unidad = "C";
        }

        RegistroTemperatura registro = new RegistroTemperatura(valor, unidad, LocalDate.now());

        System.out.println("\n--- Registro Inicial (" + registro.getFechaRegistro() + ") ---");
        System.out.printf("Temperatura registrada: %.2f %s\n", registro.getValorTemperatura(), registro.getUnidadMedida());
        System.out.println("¿Es Temperatura Extrema? " + registro.esTemperaturaExtrema());

        System.out.println("\n--- Conversión de Unidad ---");
        registro.convertirTemperatura();
        System.out.printf("Nueva temperatura: %.2f %s\n", registro.getValorTemperatura(), registro.getUnidadMedida());
        System.out.println("¿Es Temperatura Extrema? " + registro.esTemperaturaExtrema());

        scanner.close();
    }
}