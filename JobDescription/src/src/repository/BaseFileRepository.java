package repository;

import domain.Entity;
import validator.Validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by claudiu on 21.10.2016.
 */
public class BaseFileRepository<E extends Entity> extends BaseRepository<E> implements FileRepository{
    private String fileName;
//    private Repository<E> repository;

    public BaseFileRepository(Validator<E> validator, String fileName) {
        super(validator);
        this.fileName = fileName;
//        this.repository = repository;
        this.loadData();
    }

    public void loadData() {

    }

    public void writeData() {
    }

}
