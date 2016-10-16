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

    public List<Job> getJobs() {
        List<Job> jobs = (List<Job>)(List<?>) super.getAll();
        return jobs;
    }
}
