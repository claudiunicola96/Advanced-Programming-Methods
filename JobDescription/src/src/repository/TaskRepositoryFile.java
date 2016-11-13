package repository;

import domain.Task;
import validator.Validator;

/**
 * Created by claudiu on 02.11.2016.
 */
public class TaskRepositoryFile extends BaseFileRepository<Task> {
    private Validator<Task> validator;
    private String fileName;

    public TaskRepositoryFile(Validator<Task> validator, String fileName) {
        this.validator = validator;
        this.fileName = fileName;
    }

    public Validator<Task> getValidator() {
        return this.validator;
    }

    public String getFileName() {
        return fileName;
    }

    public Task createFromFormat(String line) {
        String[] tokens = line.split("\\|");
        return new Task(Integer.parseInt(tokens[0]), tokens[1]);
    }
}
