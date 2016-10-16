package repository;

import domain.Entity;
import domain.Sheet;


import java.util.*;

/**
 * Created by claudiu on 11.10.2016.
 */
public class BaseRepository implements Repository<Entity> {

    private List<Entity> items;

    public BaseRepository() {
        this.items = new ArrayList<>();
    }

    public void add(Entity item) {
        this.items.add(item);
    }

    public void remove(Entity item) {
        this.items.remove(item);
    }

    public void update(Entity item) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == item.getId()) {
                int index = this.items.indexOf(entity);
                this.items.set(index, item);
                return;
            }
        }
    }

    public List<? extends Entity> getAll() {
        return this.items;
    }

    public int getLastId() {
        if (this.items.size() == 0)
            return 0;
        return this.items.get(this.items.size() - 1).getId();
    }

    @SuppressWarnings("unchecked")
    public boolean existId(int id) {
        for (Entity entity : this.getAll()) {
            if (entity.getId() == id)
                return true;
        }
        return false;
    }

}
