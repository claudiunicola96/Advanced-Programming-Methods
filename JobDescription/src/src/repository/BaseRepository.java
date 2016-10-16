package repository;

import domain.Entity;
import util.Array;

/**
 * Created by claudiu on 11.10.2016.
 */
public class BaseRepository<GenericType extends Entity> {

    private Array<GenericType> items;

    public BaseRepository() {
        this.items = new Array<GenericType>();
    }

    public void add(GenericType item) {
        this.items.add(item);
    }

    public void remove(int id) {
        int indexToRemove = -1;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1)
            this.items.remove(indexToRemove);
    }

    public void update(GenericType item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId() == item.getId()) {
                this.items.set(i, item);
            }
        }
    }

    public Array<GenericType> getAll() {
        return this.items;
    }
}
