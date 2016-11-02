import controller.Controller;
import domain.Job;
import domain.Sheet;
import domain.Task;
import repository.*;
import tests.BaseRepositoryTest;
import validator.JobValidator;
import validator.SheetValidator;
import validator.TaskValidator;
import view.ConsoleView;

import java.io.File;

/**
 * Created by claudiu on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) throws Exception, Throwable {
        //tests
        BaseRepositoryTest baseRepositoryTest = new BaseRepositoryTest();
        baseRepositoryTest.testSuiteRun();

//      In memory
//        Repository<Task> taskRepository = new TaskRepository(new TaskValidator());
//        Repository<Job> jobRepository = new JobRepository(new JobValidator());
//        Repository<Sheet> sheetRepository = new SheetRepository(new SheetValidator());
//        Controller controller = new Controller(taskRepository, jobRepository, sheetRepository);

        Repository<Job> jobRepositoryFile = new BaseFileRepository<>(
                new JobRepositoryFile(new JobValidator(), new File("jobs.txt").getAbsolutePath())
        );
        Repository<Task> taskRepositoryFile = new BaseFileRepository<>(
                new TaskRepositoryFile(new TaskValidator(), new File("tasks.txt").getAbsolutePath())
        );
        Repository<Sheet> sheetRepositoryFile = new BaseFileRepository<>(
                new SheetRepositoryFile(
                        jobRepositoryFile,
                        taskRepositoryFile,
                        new SheetValidator(),
                        new File("sheets.txt").getAbsolutePath())
        );
        Controller controller = new Controller(taskRepositoryFile, jobRepositoryFile, sheetRepositoryFile);
        ConsoleView consoleView = new ConsoleView(controller);

        consoleView.run();
        jobRepositoryFile.finalize();
    }
}
