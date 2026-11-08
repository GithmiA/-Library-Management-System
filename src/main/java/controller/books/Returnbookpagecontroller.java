package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ReturnBookDTO;

import java.io.IOException;

public class Returnbookpagecontroller {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnReturn;

    @FXML
    private DatePicker dpReturnDate;

    @FXML
    private Label lblBookTitle;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblFullName;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblStatus;

    @FXML
    private TextField txtSearchBox;

    Returnbookcontroller returnbookcontroller = new Returnbookcontroller();

    @FXML
    void backOnAction(ActionEvent event) {
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
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/returnbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void returnOnAction(ActionEvent event) {


        returnbookcontroller.returnBook(dpReturnDate.getValue(),txtSearchBox.getText());
        clearField();
    }

    private void clearField() {
        lblMemberId.setText("");
        lblFullName.setText("");
        lblPhoneNumber.setText("");
        lblBookTitle.setText("");
        lblBorrowedDate.setText("");
        lblDueDate.setText("");
        lblStatus.setText("");

    }


    @FXML
    void searchBook(MouseEvent event) {
        ReturnBookDTO returnBookDTO = returnbookcontroller.load(txtSearchBox.getText());

        if (returnBookDTO != null) {

            lblMemberId.setText(returnBookDTO.getMemberId());
            lblFullName.setText(returnBookDTO.getFullName());
            lblPhoneNumber.setText(returnBookDTO.getPhoneNumber());
            lblStatus.setText(returnBookDTO.getStatus());
            lblBookTitle.setText(returnBookDTO.getBookTitle());
            lblBorrowedDate.setText(returnBookDTO.getIssueDate());
            lblDueDate.setText(returnBookDTO.getDueDate());
        }




    }

}
