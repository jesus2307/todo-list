
package model;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private String description;
    private String category;
    private int priority;
    private Date dueDate;
    private boolean completed;

    public Task(int id, String name, String description, String category, int priority, Date dueDate, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nombre: " + name +
                ", Descripción: " + description +
                ", Categoría: " + category +
                ", Prioridad: " + priority +
                ", Fecha de Vencimiento: " + dueDate +
                ", Completada: " + completed;
    }
}
