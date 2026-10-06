package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class addmemberpagecontroller {

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Label txtFullName;

    @FXML
    private Label txtMemberId;

    @FXML
    private Label txtPhoneNumber;

    @FXML
    private Label txtxAddress;

    @FXML
    private Label txtxEmail;

    @FXML
    void addMemberOnAction(ActionEvent event) {

    }

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
    void clearOnAction(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/addmember_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}
