package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Member;
import model.MemberStore;

import java.io.IOException;

public class addmemberpagecontroller {

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void addMemberOnAction(ActionEvent event) {
        String memberId = txtMemberId.getText();
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String address = txtAddress.getText();

        Member member = new Member(memberId,fullName,email,phoneNumber,address);

        MemberStore.members.add(member);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Member Added Successfully!");
        alert.showAndWait();

        clearField();
    }
    private void clearField(){
        txtMemberId.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        txtAddress.clear();
    }

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
    void clearOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/addmember_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

}
