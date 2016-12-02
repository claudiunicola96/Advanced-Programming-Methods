package guifxml;

import domain.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.TaskService;

/**
 * Created by claudiu on 02.12.2016.
 */
public class EditTaskViewController {

    @FXML
    private TextField textFieldId;

    @FXML
    private TextField textFieldDescription;

    private TaskService service;

    Stage dialogStage;
    Task task;

    public void setService(TaskService service, Stage stage, Task task) {
        this.service = service;
        this.dialogStage = stage;
        this.task = task;
        if (null != task)
            this.setFields(task);
        else
            this.textFieldId.setText(Integer.toString(this.service.getLastId() + 1));

        this.textFieldId.setEditable(false);
        this.textFieldDescription.requestFocus();
    }

    private void setFields(Task task) {
        textFieldId.setText(Integer.toString(task.getId()));
        textFieldDescription.setText(task.getDescription());
    }

    private void clearFields() {
        textFieldId.setText("");
        textFieldDescription.setText("");
    }

    @FXML
    public void handleSave() {
        int id = Integer.parseInt(textFieldId.getText());
        String description = textFieldDescription.getText();
        Task task = new Task(id, description);
        if (this.service.existsId(task.getId()))
            this.update(task);
        else
            this.save(task);

    }

    private void update(Task task) {
        try {
            this.service.update(task);
            MessageAlert.showMessage(dialogStage, Alert.AlertType.INFORMATION, "Succes", "The task is was updated!");
        } catch (Exception e) {
            MessageAlert.showErrorMessage(dialogStage, e.getMessage());
        }
    }

    private void save(Task task) {
        try {
            this.service.save(task);
            MessageAlert.showMessage(dialogStage, Alert.AlertType.INFORMATION, "Succes", "The task is was added!");
            this.clearFields();
        } catch (Exception e) {
            MessageAlert.showErrorMessage(dialogStage, e.getMessage());
        }
    }


    @FXML
    public void handleCancel() {
        this.dialogStage.close();
    }
}
