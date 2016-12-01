package gui;

import domain.Job;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.BaseFileRepository;
import repository.JobRepository;
import repository.JobRepositoryFile;
import repository.Repository;
import service.JobService;
import validator.JobValidator;

import java.io.File;

/**
 * Created by claudiu on 18.11.2016.
 */
public class Main extends Application {

    private Repository<Job> jobRepository;

    @Override
    public void start(Stage stage) {
        jobRepository = new BaseFileRepository<>(
                new JobRepositoryFile(new JobValidator(), new File("jobs.txt").getAbsolutePath())
        );
        JobService jobService = new JobService(jobRepository);
        JobView jobView = new JobView(jobService);
        Parent root = jobView.getView();
        Scene scene = new Scene(root, 800, 800);
        stage.setTitle("Welcome to JavaFX!!");
        stage.setScene(scene);
        stage.show();
    }

    public void stop() {
        try {
            jobRepository.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
