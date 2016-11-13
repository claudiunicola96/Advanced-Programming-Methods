package repository;

import domain.Job;
import serialization.SerializableIOJobs;
import validator.Validator;

import java.io.File;

/**
 * Created by claudiu on 02.11.2016.
 */
public class JobRepositoryFile extends BaseFileRepository<Job> {
    private Validator<Job> validator;
    private String fileName;

    public JobRepositoryFile(Validator<Job> validator, String fileName) {
        this.validator = validator;
        this.fileName = fileName;
        this.loadData();
    }

    public void loadData() {
        this.items = SerializableIOJobs.deserialize(new File("Sjobs.bin").getAbsolutePath());
    }

    public void writeData() {
        SerializableIOJobs.serialize(new File("Sjobs.bin").getAbsolutePath(), this.getAll());
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

    public String transform(Job job) {
        return job.getId() + "|" + job.getName() + "|" + job.getType();
    }
}
