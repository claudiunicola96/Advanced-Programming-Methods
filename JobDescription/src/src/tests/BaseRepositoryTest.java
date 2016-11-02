package tests;

import domain.Job;
import repository.BaseRepository;
import validator.JobValidator;
import validator.Validator;

/**
 * Created by claudiu on 12.10.2016.
 */
public class BaseRepositoryTest {

    public BaseRepository baseRepository;

    @SuppressWarnings("unchecked")
    public BaseRepositoryTest() {
        this.baseRepository = new BaseRepository(new JobValidator());
        assert this.baseRepository.getAll().size() == 0;
    }
    @SuppressWarnings("unchecked")
    public void addTest() throws  Exception{
        Job job = new Job(1, "test name", "fulltime");
        this.baseRepository.add(job);

        assert this.baseRepository.getAll().size() == 2 : "add";
    }
    @SuppressWarnings("unchecked")
    public void updateTest() throws  Exception {
        Job job = new Job(1, "test", "parttime");
        this.baseRepository.update(job);
        Job job1 = (Job) this.baseRepository.getAll().get(0);
        assert job1.getName() == "test";
        assert job1.getType() == "parttime";
    }
    @SuppressWarnings("unchecked")
    public void deleteTest() throws  Exception {
        this.baseRepository.remove(new Job(1, "test", "parttime"));
        assert this.baseRepository.getAll().size() == 0;
    }

    public void testSuiteRun() throws  Exception {
        this.addTest();
        this.updateTest();
        this.deleteTest();
    }
}
