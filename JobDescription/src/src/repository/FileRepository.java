package repository;

import domain.Entity;
import validator.Validator;

import java.util.List;

/**
 * Created by claudiu on 28.10.2016.
 */
public interface FileRepository<E extends Entity> extends Repository<E> {
    void loadData();
    void writeData();
    E createFromFormat(String line);
    String transform(E Entity);
    Validator<E> getValidator();
    String getFileName();
    List<E> getAll();
}
