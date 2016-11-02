import controller.Controller;
import repository.JobRepository;
import repository.SheetRepository;
import repository.TaskRepository;
import tests.BaseRepositoryTest;
import validator.JobValidator;
import validator.SheetValidator;
import validator.TaskValidator;
import view.ConsoleView;

/**
 * Created by claudiu on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //tests
        BaseRepositoryTest baseRepositoryTest = new BaseRepositoryTest();
        baseRepositoryTest.testSuiteRun();

        TaskRepository taskRepository = new TaskRepository(new TaskValidator());
        JobRepository jobRepository = new JobRepository(new JobValidator());
        SheetRepository sheetRepository = new SheetRepository(new SheetValidator());
        Controller controller = new Controller(taskRepository, jobRepository, sheetRepository);
//        BaseFileRepository taskRepositoryFile = new BaseFileRepository<Task>(new TaskValidator(), "task.txt");
//        BaseFileRepository jobRepositoryFile = new BaseFileRepository<Job>(new JobValidator(), "job.txt");
//        BaseFileRepository sheetRepositoryFile = new BaseFileRepository<Sheet>(new SheetValidator(), "sheet.txt");
//        Controller controller = new Controller(taskRepositoryFile, jobRepositoryFile, sheetRepositoryFile);
        ConsoleView consoleView = new ConsoleView(controller);

        consoleView.run();
    }
}
