package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.ReturnBook;

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

        ReturnBook book = returnbookcontroller.load(txtSearchBox.getText());

            if(book != null) {
                lblMemberId.setText(book.getMemberId());
                lblFullName.setText(book.getName());
                lblPhoneNumber.setText(book.getPhoneNumber());
                lblStatus.setText(book.getStatus());
                lblBookTitle.setText(book.getBookTitle());
                lblBorrowedDate.setText(book.getBorrowedDate());
                lblDueDate.setText(book.getDueDate());
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("OOPS");
                alert.setHeaderText(null);
                alert.setContentText("Book not found!");
                alert.showAndWait();
            }
    }

}
