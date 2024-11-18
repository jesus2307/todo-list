
package model;

import java.util.ArrayList;
import java.util.List;

public interface TaskObserver {
    void onTaskStatusChanged(Task task);
}

class TaskSubject {
    private final List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Task task) {
        for (TaskObserver observer : observers) {
            observer.onTaskStatusChanged(task);
        }
    }
}
