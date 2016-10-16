import controller.Controller;
import exception.IdValidatorException;
import exception.JobException;
import exception.TaskException;
import repository.JobRepository;
import repository.TaskRepository;
import tests.BaseRepositoryTest;
import view.ConsoleView;

/**
 * Created by claudiu on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) throws JobException, TaskException, IdValidatorException {
        //tests
        BaseRepositoryTest baseRepositoryTest = new BaseRepositoryTest();
        baseRepositoryTest.testSuiteRun();

        TaskRepository taskRepository = new TaskRepository();
        JobRepository jobRepository = new JobRepository();
        Controller controller = new Controller(taskRepository, jobRepository);
        ConsoleView consoleView = new ConsoleView(controller);

        consoleView.run();
    }
}
