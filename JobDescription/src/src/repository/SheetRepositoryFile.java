package repository;

import domain.Job;
import domain.Sheet;
import domain.Task;
import validator.Validator;

/**
 * Created by claudiu on 02.11.2016.
 */
public class SheetRepositoryFile extends BaseFileRepository<Sheet> {
    private Validator<Sheet> validator;
    private String fileName;
    private Repository<Job> jobRepository;
    private Repository<Task> taskRepository;


    public SheetRepositoryFile(
            Repository<Job> jobRepository,
            Repository<Task> taskRepository,
            Validator<Sheet> validator,
            String fileName
    ) {
        this.jobRepository = jobRepository;
        this.taskRepository = taskRepository;
        this.validator = validator;
        this.fileName = fileName;
    }

    public Validator<Sheet> getValidator() {
        return this.validator;
    }

    public String getFileName() {
        return fileName;
    }

    public Sheet createFromFormat(String line) {
        String[] tokens = line.split("\\|");
        Job job = (Job) this.jobRepository.getEntityById(Integer.parseInt(tokens[1]));
        Task task = (Task) this.taskRepository.getEntityById(Integer.parseInt(tokens[2]));
        return new Sheet(Integer.parseInt(tokens[0]), job, task);
    }
}
