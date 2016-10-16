package tests;

import domain.Job;
import repository.BaseRepository;

/**
 * Created by claudiu on 12.10.2016.
 */
public class BaseRepositoryTest {

    public BaseRepository<Job> baseRepository;

    public BaseRepositoryTest() {
        this.baseRepository = new BaseRepository<Job>();
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

        assert this.baseRepository.getAll().get(0).getName() == "test";
        assert this.baseRepository.getAll().get(0).getType() == "parttime";
    }

    public void deleteTest() {
        this.baseRepository.remove(1);

        assert this.baseRepository.getAll().size() == 0;
    }

    public void testSuiteRun() {
        this.addTest();
        this.updateTest();
        this.deleteTest();
    }
}
