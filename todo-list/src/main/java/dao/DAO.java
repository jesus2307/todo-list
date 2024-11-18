
package dao;

import java.util.List;

public interface DAO<T> {
    void save(T t);
    List<T> getAll();
    void delete(int id);
    void updateTaskStatus(int id, boolean completed);
    List<T> findAll();
    T findById(int id);
}
