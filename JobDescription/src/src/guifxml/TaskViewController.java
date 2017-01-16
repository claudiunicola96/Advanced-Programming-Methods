package guifxml;

import domain.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.TaskService;
import util.Observable;
import util.Observer;

import java.io.IOException;

/**
 * Created by claudiu on 02.12.2016.
 */
public class TaskViewController implements Observer<Task> {

    @FXML
    private TableView<Task> taskTableView;
    @FXML
    private TableColumn<Task, String> descriptionColumn;

    TaskService service;
    ObservableList<Task> model;

    public void setService(TaskService service) {
        this.service = service;
        this.model = FXCollections.observableArrayList(service.getAll());
        this.taskTableView.setItems(model);
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        this.descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
    }

    public TaskViewController() {
    }

    public void handleSaveTask() {
        this.showTaskEditDialog(null);
    }

    public void handleUpdateTask() {
        Task task = taskTableView.getSelectionModel().getSelectedItem();
        if (task != null)
            this.showTaskEditDialog(task);
        else
            MessageAlert.showErrorMessage(null, "Please select a task");
    }

    public void handleDeleteTask() throws Exception {
        Task task = taskTableView.getSelectionModel().getSelectedItem();
        if (task != null)
            this.service.delete(task);
        else
            MessageAlert.showErrorMessage(null, "Please select a task");
    }

    public void showTaskEditDialog(Task task) {
        try {
            // create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TaskViewController.class.getResource("EditTaskView.fxml"));
            AnchorPane root = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Task");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            EditTaskViewController editTaskViewController = loader.getController();
            editTaskViewController.setService(service, dialogStage, task);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable<Task> observable) {
        TaskService service = (TaskService) observable;
        model.setAll(service.getAll());
    }
}
