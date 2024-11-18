
import dao.SQLiteTaskDAO;
import model.Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:tasks.db")) {
            SQLiteTaskDAO taskDAO = new SQLiteTaskDAO(connection);
            taskDAO.createTableIfNotExists();

            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while (true) {
                System.out.println("--- Menú de Gestión de Tareas ---");
                System.out.println("1. Agregar tarea");
                System.out.println("2. Listar todas las tareas");
                System.out.println("3. Actualizar estado de tarea");
                System.out.println("4. Eliminar tarea");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                int option;
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número del 1 al 5.");
                    scanner.nextLine(); // Limpia el buffer
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el nombre de la tarea: ");
                        String name = scanner.nextLine();
                        System.out.print("Ingrese la descripción de la tarea: ");
                        String description = scanner.nextLine();
                        System.out.print("Ingrese la categoría de la tarea: ");
                        String category = scanner.nextLine();
                        System.out.print("Ingrese la prioridad de la tarea (1-5): ");
                        int priority;
                        try {
                            priority = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Prioridad no válida. Debe ser un número entre 1 y 5.");
                            scanner.nextLine();
                            continue;
                        }
                        System.out.print("Ingrese la fecha de vencimiento (YYYY-MM-DD): ");
                        String dueDateString = scanner.nextLine();
                        try {
                            Date dueDate = dateFormat.parse(dueDateString);
                            Task newTask = new Task(0, name, description, category, priority, dueDate, false);
                            taskDAO.save(newTask);
                            System.out.println("Tarea agregada con éxito.");
                        } catch (ParseException e) {
                            System.out.println("Error en el formato de la fecha. Intente de nuevo.");
                        }
                        break;
                    case 2:
                        List<Task> tasks = taskDAO.getAll();
                        System.out.println("Listado de tareas disponibles:");
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el ID de la tarea: ");
                        int taskId;
                        try {
                            taskId = scanner.nextInt();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("ID no válido. Debe ser un número.");
                            scanner.nextLine();
                            continue;
                        }
                        System.out.print("Ingrese el nuevo estado (true para completada, false para no completada): ");
                        boolean isCompleted;
                        try {
                            isCompleted = scanner.nextBoolean();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Estado no válido. Debe ser true o false.");
                            scanner.nextLine();
                            continue;
                        }
                        taskDAO.updateTaskStatus(taskId, isCompleted);
                        System.out.println("Estado de la tarea actualizado con éxito.");
                        break;
                    case 4:
                        System.out.print("Ingrese el ID de la tarea a eliminar: ");
                        try {
                            int deleteId = scanner.nextInt();
                            scanner.nextLine();
                            taskDAO.delete(deleteId);
                            System.out.println("Tarea eliminada con éxito.");
                        } catch (InputMismatchException e) {
                            System.out.println("ID no válido. Debe ser un número.");
                            scanner.nextLine();
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione un número del 1 al 5.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
