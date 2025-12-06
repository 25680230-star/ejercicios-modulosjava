import java.util.Scanner;

public class Producto {

    private final String referenciaAlmacen;
    private int cantidadStock;
    private double precioUnitario;

    public Producto(String referencia, int stock, double precio) {
        this.referenciaAlmacen = referencia;
        this.cantidadStock = stock;
        this.precioUnitario = precio;
    }

    public void incrementarStock(int cantidadEntrada) {
        if (cantidadEntrada > 0) {
            this.cantidadStock += cantidadEntrada;
            System.out.printf("Entrada de %d unidades registrada. Nuevo stock: %d\n", cantidadEntrada, this.cantidadStock);
        } else {
            System.out.println("La cantidad de entrada debe ser positiva.");
        }
    }

    public double calcularValorTotalStock() {
        return this.cantidadStock * this.precioUnitario;
    }

    public String getReferenciaAlmacen() {
        return referenciaAlmacen;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double nuevoPrecio) {
        if (nuevoPrecio >= 0) {
            this.precioUnitario = nuevoPrecio;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ref;
        int stockInicial;
        double precio;

        System.out.println("📦 Módulo: Control de Inventario");
        System.out.println("-------------------------------------");

        System.out.print("Ingrese la referencia del producto: ");
        ref = scanner.nextLine();

        System.out.print("Ingrese la cantidad inicial en stock: ");
        stockInicial = scanner.hasNextInt() ? scanner.nextInt() : 0;

        System.out.print("Ingrese el precio unitario: $");
        precio = scanner.hasNextDouble() ? scanner.nextDouble() : 1.0;

        scanner.nextLine();

        Producto producto = new Producto(ref, stockInicial, precio);

        System.out.println("\n--- Producto Inicial (" + producto.getReferenciaAlmacen() + ") ---");
        System.out.printf("Stock: %d | Precio Unitario: $%.2f\n", producto.getCantidadStock(), producto.getPrecioUnitario());

        System.out.printf("Valor Total Inicial del Stock: $%.2f\n", producto.calcularValorTotalStock());

        System.out.println("\n--- Entrada de Mercancía ---");
        System.out.print("Ingrese la cantidad de unidades que entraron al almacén: ");
        int entrada = scanner.hasNextInt() ? scanner.nextInt() : 0;
        producto.incrementarStock(entrada);

        System.out.println("\n--- Actualización ---");
        System.out.printf("Nuevo Stock: %d\n", producto.getCantidadStock());
        System.out.printf("Nuevo Valor Total del Stock: $%.2f\n", producto.calcularValorTotalStock());

        scanner.close();
    }
}