package tests;

import domain.Job;
import repository.BaseRepository;

/**
 * Created by claudiu on 12.10.2016.
 */
public class BaseRepositoryTest {

    public BaseRepository baseRepository;

    public BaseRepositoryTest() {
        this.baseRepository = new BaseRepository();
        assert this.baseRepository.getAll().size() == 0;
    }

    public void addTest() {
        Job job = new Job(1, "test name", "fulltime");
        this.baseRepository.add(job);

        assert this.baseRepository.getAll().size() == 2 : "add";
    }

    public void updateTest() {
        Job job = new Job(1, "test", "parttime");
        this.baseRepository.update(job);
        Job job1 = (Job) this.baseRepository.getAll().get(0);
        assert job1.getName() == "test";
        assert job1.getType() == "parttime";
    }

    public void deleteTest() {
        this.baseRepository.remove(new Job(1, "test", "parttime"));
        assert this.baseRepository.getAll().size() == 0;
    }

    public void testSuiteRun() {
        this.addTest();
        this.updateTest();
        this.deleteTest();
    }
}
