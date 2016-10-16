package controller;

import domain.Job;
import domain.Task;
import exception.JobException;
import exception.TaskException;
import repository.JobRepository;
import repository.TaskRepository;
import util.Array;
import validator.JobValidator;
import validator.TaskValidator;


/**
 * Created by claudiu on 11.10.2016.
 */
public class Controller {
    private TaskRepository taskRepository;
    private JobRepository jobRepository;
    private TaskValidator taskValidator;
    private JobValidator jobValidator;
    private int lastJobId = 1;
    private int lastTaskId = 1;

    public Controller(TaskRepository taskRepository, JobRepository jobRepository) {
        this.taskRepository = taskRepository;
        this.jobRepository = jobRepository;
        this.taskValidator = new TaskValidator();
        this.jobValidator = new JobValidator();
    }

    public void addJob(String name, String type) throws JobException {
        Job job = new Job(this.lastJobId++, name, type);
        this.jobValidator.validate(job);
        this.jobRepository.add(job);
    }

    public void deleteJob(int id) {
        this.jobRepository.remove(id);
    }

    public void updateJob(int id, String name, String type) throws JobException {
        this.jobRepository.update(new Job(id, name, type));
    }

    public void addTask(String description) throws TaskException {
        Task task = new Task(this.lastTaskId++, description);
        this.taskValidator.validate(task);
        this.taskRepository.add(task);
    }

    public void deleteTask(int id) {
        this.taskRepository.remove(id);
    }

    public void updateTask(int id, String description) throws TaskException {
        this.taskRepository.update(new Task(id, description));
    }

    public Array<Job> getJobs() {
        return this.jobRepository.getAll();
    }

    public Array<Task> getTasks() {
        return this.taskRepository.getAll();
    }
}
