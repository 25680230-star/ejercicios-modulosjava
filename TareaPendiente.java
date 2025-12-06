import java.util.Scanner;

public class TareaPendiente {

    public enum Prioridad {
        BAJA, MEDIA, ALTA
    }

    private String descripcion;
    private Prioridad prioridad;
    private boolean completada;

    public TareaPendiente(String descripcion, Prioridad prioridad, boolean completada) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    // Comportamiento 1: Cambiar Estado a Completada (No se usa en el main interactivo, pero se mantiene)
    public void marcarComoCompletada() {
        if (!this.completada) {
            this.completada = true;
        }
    }

    // Comportamiento 2: Determinar si es Urgente
    public boolean esUrgente() {
        return this.prioridad == Prioridad.ALTA && !this.completada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indice = -1;

        // 📝 Tareas Predefinidas (marcadas por el código)
        TareaPendiente[] listaTareas = {
                new TareaPendiente("Revisar informe trimestral", Prioridad.ALTA, false), // Urgente
                new TareaPendiente("Comprar café para la oficina", Prioridad.BAJA, false), // Pendiente
                new TareaPendiente("Enviar email a cliente X", Prioridad.MEDIA, false), // Pendiente
                new TareaPendiente("Actualizar sistema operativo", Prioridad.ALTA, true), // Completada, No urgente
                new TareaPendiente("Preparar siguiente reunión", Prioridad.MEDIA, true) // Completada
        };

        System.out.println("📝 Módulo: Gestión de Tareas (Consulta)");
        System.out.println("----------------------------------------");

        // Mostrar lista de tareas disponibles
        System.out.println("Tareas disponibles para consulta:");
        for (int i = 0; i < listaTareas.length; i++) {
            System.out.println((i + 1) + ". " + listaTareas[i].getDescripcion());
        }

        // Bucle de interacción para seleccionar la tarea
        while (indice != 0) {
            System.out.print("\nSeleccione el número de la tarea (1-" + listaTareas.length + ") o ingrese 0 para salir: ");

            if (scanner.hasNextInt()) {
                indice = scanner.nextInt();

                if (indice >= 1 && indice <= listaTareas.length) {
                    TareaPendiente tareaSeleccionada = listaTareas[indice - 1];

                    System.out.println("\n--- Detalles de la Tarea " + indice + " ---");
                    System.out.println("Descripción: " + tareaSeleccionada.getDescripcion());

                    // Comportamiento 2 (Urgencia) y Prioridad
                    System.out.println("Prioridad Asignada: " + tareaSeleccionada.getPrioridad());
                    System.out.println("¿Está COMPLETADA?: " + (tareaSeleccionada.isCompletada() ? "Sí" : "No"));
                    System.out.println("¿Es URGENTE?: " + (tareaSeleccionada.esUrgente() ? "SI (Prioridad ALTA y pendiente)" : "No"));

                } else if (indice != 0) {
                    System.out.println("Número de tarea no válido.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
                indice = -1;
            }
        }

        System.out.println("Saliendo del gestor de tareas.");
        scanner.close();
    }
}