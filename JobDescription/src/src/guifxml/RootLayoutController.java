package guifxml;

import javafx.fxml.FXML;

/**
 * Created by claudiu on 02.12.2016.
 */
public class RootLayoutController {
    Main mainApp;

    public RootLayoutController() {
    }

    public void setMainApp(Main app) {
        this.mainApp = app;
    }

    @FXML
    public void handleTaskCRUD() {
//        this.mainApp.initTaskStudentViewLayout();
    }

    public void handleJobsCRUD() {

    }

}
