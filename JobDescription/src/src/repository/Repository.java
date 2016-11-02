package repository;


import domain.Entity;
import validator.Validator;

import java.util.List;

/**
 * Created by claudiu on 16.10.2016.
 */
public interface Repository<E extends Entity> {

    void add(E entity) throws Exception;

    void remove(E entity) throws Exception;

    void update(E entity) throws Exception;

    int getLastId();

    Entity getEntityById(int id);

    boolean existId(int id);

    List<E> getAll();
}
