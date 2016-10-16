package util;

import java.util.Iterator;

/**
 * Created by claudiu on 11.10.2016.
 */
public class Array<GenericType> implements Iterable<GenericType> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] items;
    private int size;
    private int capacity;

    public Array() {
        this.items = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    @Override
    public Iterator<GenericType> iterator() {
        return new Iterator<GenericType>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public GenericType next() {
                return get(index++);
            }

            public void remove() {
            }
        };
    }

    @SuppressWarnings("unchecked")
    public GenericType get(int position) {
        return (GenericType) this.items[position];
    }

    public void add(GenericType object) {
        this.checkSize();
        this.items[size++] = object;
    }

    public void remove(int index) {
        int numberMoves = this.size - index - 1;
        if (numberMoves > 0) {
            System.arraycopy(this.items, index + 1, this.items, index, numberMoves);
        }
        this.items[--size] = null;
    }

    public void set(int position, GenericType object) {
        this.items[position] = object;
    }

    private void checkSize() {
        if (this.size == this.capacity) {
            this.increaseCapacity();
        }
    }

    private void increaseCapacity() {
        Object[] newItems = new Object[this.capacity * 2];
//        System.arraycopy();
        this.items = newItems;
        this.capacity *= 2;
    }

    public int size() {
        return this.size;
    }
}
