
package model;

import java.util.Date;

public class TaskFactory {

    public static Task createTask(int id, String name, String description, String category, int priority, Date dueDate, boolean completed) {
        return new Task(id, name, description, category, priority, dueDate, completed);
    }
}
