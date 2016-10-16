package domain;

import java.util.Arrays;
import java.util.*;

/**
 * Created by claudiu on 16.10.2016.
 */
public class Sheet extends Entity {
    private int id;
    private Job job;
    private Task task;

    public Sheet(int id, Job job, Task task) {
        this.id = id;
        this.job = job;
        this.task = task;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "id=" + id +
                ", job=" + job +
                ", task=" + task +
                '}';
    }
}
