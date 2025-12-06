import java.util.Scanner;

public class Empleado {

    // Atributos
    private final String claveEmpleado; // Usaremos el nombre como clave
    private double salarioMensual;
    private final double porcentajeRetencion;

    public Empleado(String clave, double salario, double retencion) {
        this.claveEmpleado = clave;
        this.salarioMensual = salario;
        this.porcentajeRetencion = retencion;
    }

    // Comportamiento 1: Calcular Salario Neto
    public double calcularSalarioNeto() {
        double montoImpuestos = this.salarioMensual * this.porcentajeRetencion;
        return this.salarioMensual - montoImpuestos;
    }

    // Comportamiento 2: Aplicar Aumento de Salario (usado internamente para demostración)
    public void aplicarAumento(double porcentajeAumento) {
        if (porcentajeAumento > 0) {
            double montoAumento = this.salarioMensual * porcentajeAumento;
            this.salarioMensual += montoAumento;
        }
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public double getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreBuscado;

        // 🧑‍💻 Lista de Empleados con Nombres Requeridos
        Empleado[] baseEmpleados = {
                // Nombre, Salario, Retención
                new Empleado("Pedro", 15000.00, 0.20), // Salario Alto, Retención 20%
                new Empleado("Pablo", 3500.00, 0.05),  // Salario Medio, Retención 5%
                new Empleado("Gabi", 2500.00, 0.10),   // Salario Bajo, Retención 10%
                new Empleado("Pacheco", 1800.00, 0.30) // Salario Muy Bajo, Retención 30%
        };

        // Aplicamos un aumento a Pablo para tener un caso de cálculo diferente
        baseEmpleados[1].aplicarAumento(0.15); // Aumento del 15% a Pablo

        System.out.println("--- 🧑‍💻 Módulo: Control de Empleados ---");
        System.out.println("Nombres disponibles: Pedro, Pablo, Gabi, Pacheco");
        System.out.println("----------------------------------------");

        // Bucle de interacción
        while (true) {
            System.out.print("\nIngrese el nombre del empleado a consultar (o 'salir'): ");
            nombreBuscado = scanner.nextLine().trim();

            if (nombreBuscado.equalsIgnoreCase("salir")) {
                break;
            }

            Empleado encontrado = null;
            // Buscar empleado por nombre (clave)
            for (Empleado emp : baseEmpleados) {
                if (emp.getClaveEmpleado().equalsIgnoreCase(nombreBuscado)) {
                    encontrado = emp;
                    break;
                }
            }

            if (encontrado != null) {
                // Mostrar la información del empleado encontrado
                System.out.println("\n*** Información de " + encontrado.getClaveEmpleado() + " ***");
                System.out.printf("Salario Bruto Mensual: $%.2f\n", encontrado.getSalarioMensual());
                System.out.printf("Porcentaje de Retención: %.0f%%\n", encontrado.getPorcentajeRetencion() * 100);

                // Comportamiento 1: Cálculo del Salario Neto
                System.out.printf("Salario NETO (calculado): $%.2f\n", encontrado.calcularSalarioNeto());
            } else {
                System.out.println("❌ Nombre de empleado no encontrado. Intente de nuevo.");
            }
        }

        System.out.println("Saliendo del sistema de consultas.");
        scanner.close();
    }
}
