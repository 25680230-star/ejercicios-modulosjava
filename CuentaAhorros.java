import java.util.Scanner;

public class CuentaAhorros {

    private final String numeroCuenta;
    private final String nombreTitular;
    private double saldoActual;

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = titular;
        this.saldoActual = saldoInicial;
    }

    // Comportamiento 1: Realizar Depósito
    public void realizarDeposito(double cantidad) {
        if (cantidad > 0) {
            this.saldoActual += cantidad;
            System.out.printf("✅ Depósito exitoso de $%.2f. Saldo actual: $%.2f\n", cantidad, this.saldoActual);
        } else {
            System.out.println("⚠️ La cantidad a depositar debe ser positiva.");
        }
    }

    // Comportamiento 2: Simular Retiro
    public boolean simularRetiro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("⚠️ La cantidad a retirar debe ser positiva.");
            return false;
        }

        if (cantidad <= this.saldoActual) {
            this.saldoActual -= cantidad;
            System.out.printf("✅ Retiro exitoso de $%.2f. Nuevo saldo: $%.2f\n", cantidad, this.saldoActual);
            return true;
        } else {
            System.out.printf("❌ Fondos insuficientes. Saldo actual: $%.2f. Solicitado: $%.2f\n", this.saldoActual, cantidad);
            return false;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String titular, numCuenta;
        double saldoInicial, cantidad;
        int opcion = 0;

        System.out.println("🏦 Módulo: Sistema de Cuentas Bancarias");
        System.out.println("----------------------------------------");

        // --- 1. Crear la Cuenta (Interacción Inicial) ---
        System.out.print("Ingrese el nombre del titular: ");
        titular = scanner.nextLine();

        System.out.print("Ingrese el número de cuenta: ");
        numCuenta = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: $");
        if (scanner.hasNextDouble()) {
            saldoInicial = scanner.nextDouble();
        } else {
            System.out.println("Saldo no válido. Usando $0.00 por defecto.");
            saldoInicial = 0.00;
        }
        scanner.nextLine(); // Consumir nueva línea

        CuentaAhorros cuenta = new CuentaAhorros(numCuenta, titular, saldoInicial);

        // --- 2. Bucle de Operaciones (Interacción Continua) ---
        while (opcion != 3) {
            System.out.println("\n--- Cuenta " + cuenta.getNumeroCuenta() + " ---");
            System.out.printf("Titular: %s | Saldo: $%.2f\n", cuenta.getNombreTitular(), cuenta.getSaldoActual());

            System.out.println("\n--- Menú de Operaciones ---");
            System.out.println("1. Realizar Depósito");
            System.out.println("2. Simular Retiro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Cantidad a depositar: $");
                        if (scanner.hasNextDouble()) {
                            cantidad = scanner.nextDouble();
                            cuenta.realizarDeposito(cantidad);
                        } else {
                            System.out.println("Entrada no válida.");
                        }
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.print("Cantidad a retirar: $");
                        if (scanner.hasNextDouble()) {
                            cantidad = scanner.nextDouble();
                            cuenta.simularRetiro(cantidad);
                        } else {
                            System.out.println("Entrada no válida.");
                        }
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema. Gracias por su uso.");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
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