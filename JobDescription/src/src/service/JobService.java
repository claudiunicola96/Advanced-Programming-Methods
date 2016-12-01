package service;

import domain.Job;
import repository.Repository;
import util.Observable;
import util.Observer;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by claudiu on 18.11.2016.
 */
public class JobService implements Observable<Job> {
    private Repository<Job> jobRepository;
    protected List<Observer<Job>> observers = new ArrayList<Observer<Job>>();

    public JobService(Repository<Job> jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void save(Job jobParam) throws Exception {
        this.jobRepository.add(jobParam);
        this.notifyObservers();
    }

    public void update(Job jobParam) throws Exception {
        this.jobRepository.update(jobParam);
        this.notifyObservers();
    }

    public void delete(Job jobParam) throws Exception {
        this.jobRepository.remove(jobParam);
        this.notifyObservers();
    }

    public List<Job> getAll() {
        return jobRepository.getAll();
    }

    public int getLastId() {
        return this.jobRepository.getLastId();
    }

    @Override
    public void addObserver(Observer<Job> o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<Job> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Job> o : observers) {
            o.update(this);
        }
    }
}
