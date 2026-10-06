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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class managemembercontroller {

    @FXML
    private TableColumn<?, ?> actionColumn;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnpage1;

    @FXML
    private Button btnpage2;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private ImageView imgSearch;

    @FXML
    private TableView<?> memberTable;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> phonenumberColumn;

    @FXML
    private TextField txtSearchById;

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void searchById(MouseEvent event) {

    }

}
