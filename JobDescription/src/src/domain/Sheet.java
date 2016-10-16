package domain;

import java.util.Arrays;
import java.util.*;

/**
 * Created by claudiu on 16.10.2016.
 */
public class Sheet extends Entity {
    private int id;
    private int jobId;
    private int taskId;

    public Sheet(int id, int jobId, int taskId) {
        this.id = id;
        this.jobId = jobId;
        this.taskId = taskId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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
                ", jobId=" + jobId +
                ", taskId=" + taskId +
                '}';
    }
}
