package repository;


import domain.Entity;

import java.util.Collection;

/**
 * Created by claudiu on 16.10.2016.
 */
public interface Repository<E extends Entity> {

    void add(E entity);

    void remove(E entity);

    void update(E entity);

    Collection<?> getAll();
}
