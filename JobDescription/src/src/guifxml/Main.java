package guifxml;

import domain.Task;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import repository.BaseFileRepository;
import repository.Repository;
import repository.TaskRepositoryFile;
import service.TaskService;
import validator.TaskValidator;

import java.io.File;
import java.io.IOException;

/**
 * Created by claudiu on 02.12.2016.
 */
public class Main extends Application {

    BorderPane rootLayout;
    AnchorPane centerLayout;
    Stage primaryStage;
    Repository<Task> taskRepository;
    TaskService taskService;


    @Override
    public void start(Stage primaryStage) throws Exception {
        taskRepository = new BaseFileRepository<>(
                new TaskRepositoryFile(new TaskValidator(), new File("tasks.txt").getAbsolutePath())
        );
        taskService = new TaskService(taskRepository);

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Task Management System");

        this.initRootLayout();
        this.initTaskViewLayout();
    }

    private void initRootLayout() {
        try {
            //Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/guifxml/RootLayout.fxml"));
            rootLayout = loader.load();
            RootLayoutController rootController = loader.getController();
            rootController.setMainApp(this);
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initTaskViewLayout() {
        try {
            // Load student view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/guifxml/TaskView.fxml"));
            centerLayout = loader.load();
            rootLayout.setCenter(centerLayout);
            //set the service and the model for controller class
            TaskViewController taskViewController = loader.getController();
            taskViewController.setService(taskService);
            taskService.addObserver(taskViewController);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void stop() {
        try {
            taskRepository.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
