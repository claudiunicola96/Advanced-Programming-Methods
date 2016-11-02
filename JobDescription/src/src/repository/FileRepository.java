package repository;

import domain.Entity;
import validator.Validator;

/**
 * Created by claudiu on 28.10.2016.
 */
public interface FileRepository<E extends Entity> {
    void loadData();
    void writeData();
    E createFromFormat(String line);
    Validator<E> getValidator();
    String getFileName();
}
