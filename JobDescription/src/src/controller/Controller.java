package controller;

import domain.Job;
import domain.Task;
import exception.IdValidatorException;
import exception.JobException;
import exception.TaskException;
import repository.JobRepository;
import repository.TaskRepository;
import validator.IdValidator;
import validator.JobValidator;
import validator.TaskValidator;

import java.util.*;


/**
 * Created by claudiu on 11.10.2016.
 */
public class Controller {
    private TaskRepository taskRepository;
    private JobRepository jobRepository;
    private TaskValidator taskValidator;
    private JobValidator jobValidator;
    private IdValidator idValidator;
    private int lastJobId = 1;
    private int lastTaskId = 1;

    public Controller(TaskRepository taskRepository, JobRepository jobRepository) {
        this.taskRepository = taskRepository;
        this.jobRepository = jobRepository;
        this.taskValidator = new TaskValidator();
        this.jobValidator = new JobValidator();
        this.idValidator = new IdValidator();
    }

    public void addJob(String name, String type) throws JobException {
        Job job = new Job(this.lastJobId++, name, type);
        this.jobValidator.validate(job);
        this.jobRepository.add(job);
    }

    public void deleteJob(int id) throws IdValidatorException {
        this.idValidator.validate(id, this.jobRepository.getLastId());
        Job job = this.jobRepository.getJobById(id);
        this.jobRepository.remove(job);
    }

    public void updateJob(int id, String name, String type) throws JobException {
        this.jobRepository.update(new Job(id, name, type));
    }

    public void addTask(String description) throws TaskException {
        Task task = new Task(this.lastTaskId++, description);
        this.taskValidator.validate(task);
        this.taskRepository.add(task);
    }

    public void deleteTask(int id) throws IdValidatorException {
        this.idValidator.validate(id, this.taskRepository.getLastId());
        Task task = this.taskRepository.getTaskById(id);
        this.taskRepository.remove(task);
    }

    public void updateTask(int id, String description) throws TaskException {
        this.taskRepository.update(new Task(id, description));
    }

    public List<Job> getJobs() {
        return this.jobRepository.getJobs();
    }

    public List<Task> getTasks() {
        return this.taskRepository.getTasks();
    }
}
