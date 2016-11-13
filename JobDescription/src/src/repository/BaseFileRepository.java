package repository;

import domain.Entity;
import domain.Job;
import validator.Validator;

import java.io.*;

/**
 * Created by claudiu on 21.10.2016.
 */
public class BaseFileRepository<E extends Entity> extends BaseRepository<E> implements FileRepository<E> {

    private FileRepository<E> repository;

    public BaseFileRepository() {
    }

    public BaseFileRepository(FileRepository<E> repository) {
        super(repository.getValidator());
        this.repository = repository;
        this.loadData();
    }

    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.repository.getFileName()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                E obj = this.createFromFormat(line);
                this.validator.validate(obj);
                this.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();        }
    }

    public void writeData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.repository.getFileName()))) {
            for (E entity : this.getAll()) {
                writer.write(this.repository.transform(entity));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public E createFromFormat(String line) {
        return this.repository.createFromFormat(line);
    }

    public String transform(E entity) {
        return this.repository.transform(entity);
    }

    public String getFileName() {
        return this.repository.getFileName();
    }

    public Validator<E> getValidator() {
        return this.repository.getValidator();
    }

    public void finalize() {
        this.writeData();
    }
}
