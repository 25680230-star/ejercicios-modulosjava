import java.util.Scanner;

public class Rectangulo {

    private double base;
    private double altura;
    private final String etiquetaID;

    public Rectangulo(double base, double altura, String id) {
        this.base = base;
        this.altura = altura;
        this.etiquetaID = id;
    }

    // Comportamiento 1: Calcular Área
    public double calcularArea() {
        return this.base * this.altura;
    }

    // Comportamiento 2: Determinar Perímetro
    public double calcularPerimetro() {
        return 2 * (this.base + this.altura);
    }

    // Getters de apoyo
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public String getEtiquetaID() {
        return etiquetaID;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String id;
        double base;
        double altura;

        System.out.println(" Módulo: Geometría Básica (Rectángulo)");


        System.out.print("Ingrese la etiqueta de identificación del rectángulo: ");
        id = scanner.nextLine();

        System.out.print("Ingrese la longitud de la BASE: ");
        if (scanner.hasNextDouble()) {
            base = scanner.nextDouble();
        } else {
            System.out.println("Valor no válido. Usando Base=5.0 por defecto.");
            base = 5.0;
        }

        System.out.print("Ingrese la longitud de la ALTURA: ");
        if (scanner.hasNextDouble()) {
            altura = scanner.nextDouble();
        } else {
            System.out.println("Valor no válido. Usando Altura=3.0 por defecto.");
            altura = 3.0;
        }
        scanner.close();

        // Crear el objeto Rectangulo
        Rectangulo miRectangulo = new Rectangulo(base, altura, id);

        // --- 2. Mostrar Comportamientos Calculados ---

        System.out.println("\n--- Resultados del Rectángulo " + miRectangulo.getEtiquetaID() + " ---");
        System.out.printf("Base: %.2f | Altura: %.2f\n", miRectangulo.getBase(), miRectangulo.getAltura());

        // Comportamiento 1: Área
        double area = miRectangulo.calcularArea();
        System.out.printf("Área Calculada: %.2f unidades cuadradas\n", area);

        // Comportamiento 2: Perímetro
        double perimetro = miRectangulo.calcularPerimetro();
        System.out.printf("Perímetro Calculado: %.2f unidades\n", perimetro);
    }
}