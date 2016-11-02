package repository;

import domain.Job;
import validator.Validator;

/**
 * Created by claudiu on 02.11.2016.
 */
public class JobRepositoryFile extends BaseFileRepository<Job> {
    private Validator<Job> validator;
    private String fileName;

    public JobRepositoryFile(Validator<Job> validator, String fileName) {
        this.validator = validator;
        this.fileName = fileName;
    }

    public Validator<Job> getValidator() {
        return this.validator;
    }

    public String getFileName() {
        return fileName;
    }

    public Job createFromFormat(String line) {
        String[] tokens = line.split("\\|");
        return new Job(Integer.parseInt(tokens[0]), tokens[1], tokens[2]);
    }
}
