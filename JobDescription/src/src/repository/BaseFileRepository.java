package repository;

import domain.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by claudiu on 21.10.2016.
 */
public class BaseFileRepository<E extends Entity> extends BaseRepository<E> implements FileRepository{
    private String fileName;
    private Repository<E> repository;

    public BaseFileRepository(Repository<E> repository, String fileName) {
        this.repository = repository;
        this.fileName = fileName;
        this.loadData();
    }

    public void loadData() {

    }

    public void writeData() {
    }

}
