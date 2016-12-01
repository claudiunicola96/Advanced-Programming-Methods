package gui;

import domain.Job;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import service.JobService;
import util.Observable;
import util.Observer;


/**
 * Created by claudiu on 20.11.2016.
 */
public class JobViewController implements Observer<Job> {
    private ObservableList<Job> model;
    private JobView jobView;
    JobService jobService;

    public JobViewController(JobService jobService, JobView jobView) {
        this.jobView = jobView;
        this.jobView.textFieldId.setEditable(false);
        this.model = FXCollections.observableArrayList(jobService.getAll());
        jobView.jobTableView.setItems(model);
        this.jobService = jobService;
    }

    public Job extractJob() {
        int id;
        if (this.jobView.textFieldId.getText().trim().isEmpty())
            id = this.jobService.getLastId() + 1;
        else
            id = Integer.parseInt(this.jobView.textFieldId.getText());

        String jobName = this.jobView.textFieldJobName.getText();
        String jobType = "";
        if (this.jobView.choiceBoxType.getSelectionModel().getSelectedItem() != null) {
            jobType = this.jobView.choiceBoxType.getSelectionModel().getSelectedItem().toString();
        }


        return new Job(id, jobName, jobType);
    }

    static void showMessage(Alert.AlertType type, String header, String text) {
    }

    static void showErrorMessage(String text) {
        Alert message = new Alert(Alert.AlertType.ERROR);
        message.setTitle("Error message.");
        message.setContentText(text);
        message.showAndWait();
    }

    @Override
    public void update(Observable<Job> observable) {
        JobService service = (JobService) observable;
        this.model.setAll(service.getAll());
    }

    public void handleClearFields(ActionEvent event) {
        this.showJobDetails(null);
    }

    public void handleAddJob(ActionEvent event) {
        Job job = this.extractJob();
        try {
            this.jobService.save(job);
            showMessage(Alert.AlertType.INFORMATION, "Success!", "Job added with success.");
            this.showJobDetails(null);
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }

    public void handleUpdateJob(ActionEvent event) {
        Job job = extractJob();
        try {
            this.jobService.update(job);
            showMessage(Alert.AlertType.INFORMATION, "Success!", "Job updated with success.");
            this.showJobDetails(null);
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }

    public void handleDeleteJob(ActionEvent event) {
        Job job = extractJob();
        try {
            this.jobService.delete(job);
            showMessage(Alert.AlertType.INFORMATION, "Success!", "Job deleted with success.");
            this.showJobDetails(null);
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }

    public ChangeListener<Job> changeTableItemListener() {
        ChangeListener<Job> changeListener = (observable, oldValue, newValue) -> {
            showJobDetails(newValue);
        };

        return changeListener;
    }

    private void showJobDetails(Job job) {
        if (job == null) {
            jobView.textFieldJobName.setText("");
            jobView.choiceBoxType.getSelectionModel().clearSelection();
            jobView.textFieldId.setText("");
        } else {
            jobView.textFieldJobName.setText(job.getName());
            if (job.getType().equals("full time"))
                jobView.choiceBoxType.getSelectionModel().selectFirst();
            else
                jobView.choiceBoxType.getSelectionModel().selectLast();
            jobView.textFieldId.setText(String.valueOf(job.getId()));
        }
    }
}
