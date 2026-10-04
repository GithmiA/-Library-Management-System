package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginpagecontroller {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnclear;

    @FXML
    private Button btnreset;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void loginOnAction(ActionEvent event) {
        if(logincontroller.nameandpasswordcheck(txtusername.getText(),txtpassword.getText())){
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/maindashboard_page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }else{
            Stage stage=new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/invalidlogin_page.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.show();
        }

    }

    @FXML
    void resetOnAction(ActionEvent event) {

    }

}
