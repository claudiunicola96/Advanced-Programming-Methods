package repository;

import domain.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by claudiu on 21.10.2016.
 */
public class BaseFileRepository<E extends Entity> extends BaseRepository<E>{
    private String fileName;
    private Repository<E> repository;

    public BaseFileRepository(Repository<E> repository, String fileName) {
        this.repository = repository;
        this.fileName = fileName;
        this.read();
    }

    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Entity e = repository.createObjectByLine(line);
                this.add(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
    }

}
