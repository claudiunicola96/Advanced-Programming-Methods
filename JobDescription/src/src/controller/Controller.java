package controller;

import domain.Job;
import domain.Sheet;
import domain.Task;
import exception.IdValidatorException;
import exception.JobException;
import exception.SheetException;
import exception.TaskException;
import repository.JobRepository;
import repository.Repository;
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
    private Repository<Task> taskRepository;
    private Repository<Job> jobRepository;
    private Repository<Sheet> sheetRepository;
    private IdValidator idValidator;

    public Controller(TaskRepository taskRepository, JobRepository jobRepository, SheetRepository sheetRepository) {
        this.taskRepository = taskRepository;
        this.jobRepository = jobRepository;
        this.sheetRepository = sheetRepository;
        this.idValidator = new IdValidator();
    }

    public void addJob(String name, String type) throws Exception {
        Job job = new Job(this.jobRepository.getLastId() + 1, name, type);
        this.jobRepository.add(job);
    }

    public void deleteJob(int id) throws Exception {
        this.idValidator.validate(id, this.jobRepository.getLastId());
        Job job = (Job) this.jobRepository.getEntityById(id);
        this.jobRepository.remove(job);
    }

    public void updateJob(int id, String name, String type) throws Exception {
        this.jobRepository.update(new Job(id, name, type));
    }

    public List<Job> getJobs() {
        return this.jobRepository.getAll();
    }

    public void addTask(String description) throws Exception {
        Task task = new Task(this.taskRepository.getLastId() + 1, description);
        this.taskRepository.add(task);
    }

    public void deleteTask(int id) throws Exception {
        this.idValidator.validate(id, this.taskRepository.getLastId());
        Task task = (Task) this.taskRepository.getEntityById(id);
        this.taskRepository.remove(task);
    }

    public void updateTask(int id, String description) throws Exception {
        this.taskRepository.update(new Task(id, description));
    }

    public List<Task> getTasks() {
        return this.taskRepository.getAll();
    }

    public void addSheet(int jobId, int taskId) throws Exception {
        if (!this.jobRepository.existId(jobId))
            throw new SheetException("Job id " + jobId + " doesn't exist!");
        if (!this.taskRepository.existId(taskId))
            throw new SheetException("Task id " + taskId + " doesn't exist!");
        Sheet sheet = new Sheet(
                this.sheetRepository.getLastId() + 1,
                (Job) this.jobRepository.getEntityById(jobId),
                (Task) this.taskRepository.getEntityById(taskId));
        this.sheetRepository.add(sheet);
    }

    public List<Sheet> getSheets() {
        return this.sheetRepository.getAll();
    }

    public List<Job> getFullTimeJobs() {
//        return this.jobRepository.getJobs(this.FULL_TIME);
        return null;
    }

    public List<Job> getPartTimeJobs() {

//        return this.jobRepository.getJobs(this.PART_TIME);
        return null;
    }

    public List<Sheet> getSheetsAlphabetic() {
//        return this.sheetRepository.getSheetsAlphabetic();
        return null;
    }
}
