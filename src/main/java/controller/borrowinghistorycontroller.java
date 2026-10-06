package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class borrowinghistorycontroller {

    @FXML
    private TableColumn<?, ?> bookTitleColumn;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<?, ?> dueDateColumn;

    @FXML
    private TableColumn<?, ?> issueDateColumn;

    @FXML
    private TableColumn<?, ?> memeberIdColumn;

    @FXML
    private TableColumn<?, ?> returnDateColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableView<?> tblTableView;

    @FXML
    private TextField txtSearchById;

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void searchOnAction(MouseEvent event) {

    }

}
