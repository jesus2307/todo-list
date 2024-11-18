
import java.util.Scanner;

public class ListaDeTareas {
    private TareaDAO tareaDAO = new TareaDAO();

    public void agregarTarea(String nombre, String descripcion) {
        tareaDAO.agregarTarea(nombre, descripcion);
        System.out.println("Tarea agregada: " + nombre);
    }

    public void mostrarTareas() {
        System.out.println("Tareas:");
        for (String tarea : tareaDAO.obtenerTareas()) {
            System.out.println(tarea);
        }
    }

    public static void main(String[] args) {
        ListaDeTareas listaDeTareas = new ListaDeTareas();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Mostrar Tareas");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                System.out.print("Descripción: ");
                String descripcion = scanner.nextLine();
                listaDeTareas.agregarTarea(nombre, descripcion);
            } else if (opcion == 2) {
                listaDeTareas.mostrarTareas();
            } else if (opcion == 3) {
                break;
            }
        }
        scanner.close();
    }
}
