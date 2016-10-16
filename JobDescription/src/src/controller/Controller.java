package controller;

import domain.Job;
import domain.Sheet;
import domain.Task;
import exception.IdValidatorException;
import exception.JobException;
import exception.SheetException;
import exception.TaskException;
import repository.JobRepository;
import repository.SheetRepository;
import repository.TaskRepository;
import validator.IdValidator;
import validator.JobValidator;
import validator.SheetValidator;
import validator.TaskValidator;

import java.util.*;


/**
 * Created by claudiu on 11.10.2016.
 */
public class Controller {
    private TaskRepository taskRepository;
    private JobRepository jobRepository;
    private SheetRepository sheetRepository;
    private TaskValidator taskValidator;
    private JobValidator jobValidator;
    private IdValidator idValidator;
    private SheetValidator sheetValidator;

    public Controller(TaskRepository taskRepository, JobRepository jobRepository, SheetRepository sheetRepository) {
        this.taskRepository = taskRepository;
        this.jobRepository = jobRepository;
        this.sheetRepository = sheetRepository;
        this.taskValidator = new TaskValidator();
        this.jobValidator = new JobValidator();
        this.idValidator = new IdValidator();
        this.sheetValidator = new SheetValidator();
    }

    public void addJob(String name, String type) throws JobException {
        Job job = new Job(this.jobRepository.getLastId() + 1, name, type);
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

    public List<Job> getJobs() {
        return this.jobRepository.getJobs();
    }

    public void addTask(String description) throws TaskException {
        Task task = new Task(this.taskRepository.getLastId() + 1, description);
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

    public List<Task> getTasks() {
        return this.taskRepository.getTasks();
    }

    public void addSheet(int jobId, int taskId) throws SheetException {
        Sheet sheet = new Sheet(this.sheetRepository.getLastId() + 1, jobId, taskId);
        this.sheetValidator.validate(sheet);
        if (!this.jobRepository.existId(jobId))
            throw new SheetException("Job id " + jobId + " doesn't exist!");
        if (!this.taskRepository.existId(taskId))
            throw new SheetException("Task id " + taskId + " doesn't exist!");
        this.sheetRepository.add(sheet);
    }

    public List<Sheet> getSheets() {
        return this.sheetRepository.getSheets();
    }
}
