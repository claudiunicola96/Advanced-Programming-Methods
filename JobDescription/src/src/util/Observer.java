package util;

/**
 * Created by claudiu on 18.11.2016.
 */
public interface Observer<E> {
    void update(Observable<E> observable);
}
