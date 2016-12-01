package gui;

import domain.Job;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import service.JobService;

/**
 * Created by claudiu on 18.11.2016.
 */
public class JobView {
    BorderPane borderPane;
    TableView<Job> jobTableView = new TableView<Job>();
    TableColumn<Job, String> nameColumn = new TableColumn<>("Job Description");
    TableColumn<Job, String> typeColumn = new TableColumn<>("Job Type");

    Button buttonAdd = new Button("Add");
    Button buttonUpdate = new Button("Update");
    Button buttonDelete = new Button("Delete");
    Button buttonClear = new Button("Clear");

    TextField textFieldId = new TextField();
    TextField textFieldJobName = new TextField();
    @SuppressWarnings("unchecked")
    ChoiceBox choiceBoxType = new ChoiceBox(FXCollections.observableArrayList("full time", "part time"));

    JobViewController controller;

    public JobView(JobService service) {
        this.controller = new JobViewController(service, this);
        service.addObserver(this.controller);
        initBorderPane();
    }

    private void initBorderPane() {
        borderPane = new BorderPane();
        borderPane.setTop(initTop());
        borderPane.setCenter(initCenter());
        borderPane.setLeft(initLeft());
    }

    public BorderPane getView() {
        return borderPane;
    }

    private Label createLabel(String s, int fontSize, Color c) {
        Label l = new Label();
        l.setText(s);
        l.setFont(new Font(fontSize));
        l.setTextFill(c);
        return l;
    }

    private Node initLeft() {
        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setLeftAnchor(jobTableView, 20d);
        AnchorPane.setTopAnchor(jobTableView, 20d);

        jobTableView.setMinHeight(50d);
        jobTableView.setMaxHeight(300d);
        initTableView();
        anchorPane.getChildren().add(jobTableView);
        return anchorPane;
    }

    private void initTableView() {
        jobTableView.getColumns().add(nameColumn);
        jobTableView.getColumns().add(typeColumn);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Job, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Job, String>("type"));

        jobTableView.getSelectionModel().selectedItemProperty().addListener(this.controller.changeTableItemListener());
    }


    private Node initCenter() {
        AnchorPane anchorPane = new AnchorPane();
        GridPane gridJobDetails = new GridPane();
        gridJobDetails.setHgap(5);
        gridJobDetails.setVgap(5);
        AnchorPane.setLeftAnchor(gridJobDetails, 20d);
        AnchorPane.setTopAnchor(gridJobDetails, 20d);
        ColumnConstraints c = new ColumnConstraints();
        c.setPrefWidth(100);
        gridJobDetails.getColumnConstraints().add(c);

        Label labelJobName = createLabel("Job title:", 12, Color.BLACK);
        Label labelJobType = createLabel("Type:", 12, Color.BLACK);
        Label labelId = createLabel("Id:", 12, Color.BLACK);

        labelJobName.setStyle("-fx-font-weight: bold");
        labelJobType.setStyle("-fx-font-weight: bold");
        labelId.setStyle("-fx-font-weight: bold");

        gridJobDetails.add(labelJobName, 0, 0);
        gridJobDetails.add(labelJobType, 0, 1);
        gridJobDetails.add(labelId, 0, 2);
        gridJobDetails.add(textFieldJobName, 1, 0);
        gridJobDetails.add(choiceBoxType, 1, 1);
        gridJobDetails.add(textFieldId, 1, 2);

        anchorPane.getChildren().add(gridJobDetails);

        HBox hb = new HBox(5, buttonAdd, buttonUpdate, buttonDelete, buttonClear);
        buttonAdd.setOnAction(this.controller::handleAddJob);
        buttonUpdate.setOnAction(this.controller::handleUpdateJob);
        buttonClear.setOnAction(this.controller::handleClearFields);
        buttonDelete.setOnAction(this.controller::handleDeleteJob);

        AnchorPane.setBottomAnchor(hb, 100d);
        AnchorPane.setLeftAnchor(hb, 20d);
        anchorPane.getChildren().add(hb);


        return anchorPane;
    }

    private Node initTop() {
        AnchorPane anchorPane = new AnchorPane();

        Label l = new Label("Job description management System");
        l.setFont(new Font(22));
        l.setStyle("-fx-font-weight: bold");
        AnchorPane.setTopAnchor(l, 20d);
        AnchorPane.setRightAnchor(l, 100d);
        anchorPane.getChildren().add(l);

        Image img = new Image("logo.gif");
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(200);
        imgView.setFitWidth(200);
        imgView.setPreserveRatio(true);

        AnchorPane.setLeftAnchor(imgView, 20d);
        AnchorPane.setRightAnchor(imgView, 10d);
        anchorPane.getChildren().add(imgView);

        return anchorPane;
    }
}