package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Addbookpagecontroller {


    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPublishYear;

    @FXML
    private TextField txtQuantity;

     Addbookcontroller addbookcontroller = new Addbookcontroller();

    @FXML
    void addBookOnAction(ActionEvent event) {

        addbookcontroller.addStudent(txtBookId.getText(),txtBookTitle.getText(),txtAuthor.getText(),txtCategory.getText(),Integer.parseInt(txtPublishYear.getText()),Integer.parseInt(txtQuantity.getText()));
        clearField();
    }

    private void clearField() {
        txtBookId.clear();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        txtPublishYear.clear();
        txtQuantity.clear();
    }

    @FXML
    void backDashboardOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void clearOnAction(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/addbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}
