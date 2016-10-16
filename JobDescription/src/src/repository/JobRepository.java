package repository;

import domain.Entity;
import domain.Job;

import java.util.List;

/**
 * Created by claudiu on 11.10.2016.
 */
public class JobRepository extends BaseRepository {

    public Job getJobById(int id) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == id) {
                return (Job) entity;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Job> getJobs() {
        return (List<Job>) super.getAll();
    }
}
