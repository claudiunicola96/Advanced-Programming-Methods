package util;

/**
 * Created by claudiu on 18.11.2016.
 */
public interface Observable<E> {
    /**
     * Register an observer.
     *
     * @param o the observer
     */
    void addObserver(Observer<E> o);

    /**
     * Unregister an observer.
     *
     * @param o the observer
     */
    void removeObserver(Observer<E> o);


    void notifyObservers();
}
