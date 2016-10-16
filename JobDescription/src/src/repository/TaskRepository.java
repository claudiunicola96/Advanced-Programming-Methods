package repository;

import domain.Task;
import domain.Entity;

import java.util.List;

/**
 * Created by claudiu on 11.10.2016.
 */
public class TaskRepository extends BaseRepository {
    public Task getTaskById(int id) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == id) {
                return (Task) entity;
            }
        }
        return null;
    }

    public List<Task> getTasks() {
        List<Task> jobs = (List<Task>) (List<?>) super.getAll();
        return jobs;
    }
}
