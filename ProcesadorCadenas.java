import java.util.Scanner;

public class ProcesadorCadenas {

    private String cadenaActual;
    private final String identificadorModulo; // Ya no es final, se inicializa en el constructor
    private final int longitudMaxima = 50;

    // Constructor que recibe tanto la cadena como el identificador
    public ProcesadorCadenas(String cadenaInicial, String idModulo) {
        this.cadenaActual = cadenaInicial;
        this.identificadorModulo = idModulo; // Asignación del valor proporcionado por el usuario
    }

    public void setCadenaActual(String nuevaCadena) {
        this.cadenaActual = nuevaCadena;
    }

    public String añadirPrefijo(String prefijo) {
        return prefijo + this.cadenaActual;
    }

    public int contarEspaciosEnBlanco() {
        int contador = 0;
        for (int i = 0; i < this.cadenaActual.length(); i++) {
            if (this.cadenaActual.charAt(i) == ' ') {
                contador++;
            }
        }
        return contador;
    }

    public String getIdentificadorModulo() {
        return identificadorModulo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textoInicial;
        String idModulo;

        System.out.println("💬 Módulo: Procesamiento de Cadenas de Texto");
        System.out.println("---------------------------------------------");

        // 1. Solicitar el identificador del módulo al usuario
        System.out.print("Ingrese el IDENTIFICADOR del módulo (Ej: PROC-005): ");
        idModulo = scanner.nextLine();

        // 2. Solicitar la cadena inicial al usuario
        System.out.print("Ingrese la cadena de texto inicial: ");
        textoInicial = scanner.nextLine();

        // Inicializar el módulo con las entradas del usuario
        ProcesadorCadenas modulo = new ProcesadorCadenas(textoInicial, idModulo);

        System.out.println("\n--- PRUEBA INICIAL ---");
        System.out.println("ID Módulo: " + modulo.getIdentificadorModulo()); // Muestra el ID ingresado
        System.out.println("Cadena actual: " + modulo.cadenaActual);

        // 3. Probar Comportamiento 1
        String prefijo = "[LOG] ";
        String cadenaPrefijada = modulo.añadirPrefijo(prefijo);
        System.out.println("\nPrefijo añadido ('" + prefijo + "'): " + cadenaPrefijada);

        // 4. Probar Comportamiento 2
        int espacios = modulo.contarEspaciosEnBlanco();
        System.out.println("Espacios contados: " + espacios);

        // 5. Modificación de la cadena
        System.out.println("\n--- MODIFICACIÓN DE LA CADENA ---");
        System.out.print("Ingrese la NUEVA cadena de texto: ");
        String nuevoTexto = scanner.nextLine();

        modulo.setCadenaActual(nuevoTexto);

        System.out.println("Nueva cadena: " + modulo.cadenaActual);
        System.out.println("Nuevos espacios: " + modulo.contarEspaciosEnBlanco());

        scanner.close();
    }
}