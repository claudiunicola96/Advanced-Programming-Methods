package repository;

import domain.Entity;
import domain.Sheet;


import java.util.*;

/**
 * Created by claudiu on 11.10.2016.
 */
public class BaseRepository<E extends Entity> implements Repository<E> {

    private List<E> items;

    public BaseRepository() {
        this.items = new ArrayList<>();
    }

    public void add(E item) {
        this.items.add(item);
    }

    public void remove(E item) {
        this.items.remove(item);
    }

    public void update(E item) {
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

}
