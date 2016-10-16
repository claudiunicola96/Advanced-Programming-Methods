package repository;


import domain.Entity;

import java.util.Collection;

/**
 * Created by claudiu on 16.10.2016.
 */
public interface Repository<GenericType extends Entity> {

    void add(GenericType entity);

    void remove(GenericType entity);

    void update(GenericType entity);

    Collection<GenericType> getAll();
}
