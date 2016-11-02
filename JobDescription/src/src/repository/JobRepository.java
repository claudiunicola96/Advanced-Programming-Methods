package repository;

import domain.Entity;
import domain.Job;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudiu on 11.10.2016.
 */
public class JobRepository extends BaseRepository<Job> {
    public JobRepository(Validator<Job> validator) {
        super(validator);
    }

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
        return super.getAll();
    }

    public List<Job> getJobs(String type) {
        List<Job> jobs = new ArrayList<>();
        for (Job job : this.getJobs()) {
            if (job.getType() == type)
                jobs.add(job);
        }
        return jobs;
    }
}
