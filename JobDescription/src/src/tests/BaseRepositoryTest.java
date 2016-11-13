package tests;

import domain.Job;
import repository.BaseRepository;
import validator.JobValidator;
import validator.Validator;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by claudiu on 09.11.2016.
 */
public class BaseRepositoryTest {
    private BaseRepository<Job> repository;

    @org.junit.Before
    public void setUp() throws Exception {
        repository = new BaseRepository<>(new JobValidator());
        repository.add(new Job(1, "Test", "part time"));
        repository.add(new Job(2, "Testovici", "full time"));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        repository = null;
    }

    @org.junit.Test
    public void add() throws Exception {
        assertEquals(2, repository.getAll().size());
        Job job = new Job(3, "Programator", "full time");
        repository.add(job);
        assertEquals(3, repository.getAll().size());
        assertSame(repository.getEntityById(3), job);
    }

    @org.junit.Test
    public void remove() throws Exception {
        assertEquals(2, repository.getAll().size());
        repository.remove((Job) repository.getEntityById(2));
        assertEquals(1, repository.getAll().size());
    }

    @org.junit.Test
    public void update() throws Exception {
        Job job = new Job(1, "gramator", "part time");
        repository.update(job);
        assertEquals(job, repository.getEntityById(1));
    }

    @org.junit.Test
    public void getAll() throws Exception {
        List<Job> all = repository.getAll();
        assertEquals(2, all.size());
    }

    @org.junit.Test
    public void getLastId() throws Exception {
        assertEquals(2, repository.getLastId());
    }

    @org.junit.Test
    public void getEntityById() throws Exception {
        Job job  = new Job(1, "Test", "part time");
//        assertEquals(job, repository.getEntityById(1));
    }

}