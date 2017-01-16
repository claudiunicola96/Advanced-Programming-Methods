package service;

import domain.Task;
import repository.Repository;
import util.Observable;
import util.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudiu on 02.12.2016.
 */
public class TaskService implements Observable<Task> {

    private Repository<Task> taskRepository;
    private List<Observer<Task>> observers = new ArrayList<Observer<Task>>();

    public TaskService(Repository<Task> taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task taskParam) throws Exception {
        this.taskRepository.add(taskParam);
        this.notifyObservers();
    }

    public void delete(Task taskParam) throws Exception {
        this.taskRepository.remove(taskParam);
        this.notifyObservers();
    }

    public void update(Task taskParam) throws Exception {
        this.taskRepository.update(taskParam);
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer<Task> o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer<Task> o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Task> o : observers) {
            o.update(this);
        }
    }

    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    public int getLastId() {
        return this.taskRepository.getLastId();
    }

    public boolean existsId(int id) {
        return this.taskRepository.existId(id);
    }
}
