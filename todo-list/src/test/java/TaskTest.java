
import model.Task;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreationAndMethods() throws Exception {
        Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-31");
        Task task = new Task(1, "Test Task", "Test Description", "Test Category", 5, dueDate, false);

        // Verificar propiedades iniciales
        assertEquals(1, task.getId());
        assertEquals("Test Task", task.getName());
        assertEquals("Test Description", task.getDescription());
        assertEquals("Test Category", task.getCategory());
        assertEquals(5, task.getPriority());
        assertEquals(dueDate, task.getDueDate());
        assertFalse(task.isCompleted());

        // Modificar estado y verificar
        task.setCompleted(true);
        assertTrue(task.isCompleted());
    }
}
