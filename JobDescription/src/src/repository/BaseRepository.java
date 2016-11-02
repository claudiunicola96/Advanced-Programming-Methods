package repository;

import domain.Entity;
import validator.Validator;


import java.util.*;

/**
 * Created by claudiu on 11.10.2016.
 */
public class BaseRepository<E extends Entity> implements Repository<E> {

    protected List<E> items;
    protected Validator<E> validator;

    public BaseRepository(Validator<E> validator) {
        this.validator = validator;
        this.items = new ArrayList<>();
    }

    public BaseRepository() {
    }

    public void add(E item) throws Exception {
        this.validator.validate(item);
        this.items.add(item);
    }

    public void remove(E item) throws Exception {
        this.validator.validate(item);
        this.items.remove(item);
    }

    public void update(E item) throws Exception {
        this.validator.validate(item);
        for (Entity entity : this.getAll()) {
            if (entity.getId() == item.getId()) {
                int index = this.items.indexOf(entity);
                this.items.set(index, item);
                return;
            }
        }
    }

    public List<E> getAll() {
        return this.items;
    }

    @SuppressWarnings("unchecked")
    public boolean existId(int id) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == id)
                return true;
        }
        return false;
    }

    public int getLastId() {
        if (this.items.size() == 0)
            return 0;
        return this.items.get(this.items.size() - 1).getId();
    }

    public Entity getEntityById(int id) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }
}
