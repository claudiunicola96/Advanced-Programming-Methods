package tests;

import controller.Controller;
import domain.Job;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.JobRepository;
import repository.SheetRepository;
import repository.TaskRepository;
import validator.JobValidator;
import validator.SheetValidator;
import validator.TaskValidator;

import static org.junit.Assert.*;

/**
 * Created by claudiu on 09.11.2016.
 */
public class ControllerTest {
    Controller controller;

    @Before
    public void setUp() throws Exception {
        controller = new Controller(
                new TaskRepository(new TaskValidator()),
                new JobRepository(new JobValidator()),
                new SheetRepository(new SheetValidator())
        );
        controller.addJob("programator", "full time");
        controller.addJob("programator", "part time");
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void addJob() throws Exception {
        assertEquals(2, controller.getJobs().size());
        controller.addJob("test", "part time");
        Job job = controller.getJobs().get(2);
        assertSame(job, controller.getJobs().get(2));
    }

    @Test
    public void deleteJob() throws Exception {
        assertEquals(2, controller.getJobs().size());
        controller.deleteJob(2);
        assertEquals(1, controller.getJobs().size());
    }
}