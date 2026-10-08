package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class issuebookcontroller {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnIssueBook;

    @FXML
    private DatePicker txtDueDate;

    @FXML
    private DatePicker txtIssueBook;

    @FXML
    private ComboBox<Book> txtSelectBook;

    @FXML
    private ComboBox<Member> txtSelectMemeber;

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
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/issuebook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void issueBookOnAction(ActionEvent event) {
        Book book = txtSelectBook.getValue();
        Member member = txtSelectMemeber.getValue();

        if (book == null || member == null || txtIssueBook.getValue() == null || txtDueDate.getValue() == null){
            System.out.println("select all details");
            return;
        }
        Borrowing borrowing = new Borrowing(member.getMemberId(), member.getFullName(), book.getBookId(), book.getBookTitle(), txtIssueBook.getValue().toString(),txtDueDate.getValue().toString());
        BorrowingStore.borrowings.add(borrowing);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Book issued Successfully!");
        alert.showAndWait();
        clearFields();

    }

    private void clearFields() {
        txtSelectBook.getSelectionModel().clearSelection();
        txtSelectMemeber.getSelectionModel().clearSelection();
        txtIssueBook.setValue(null);
        txtDueDate.setValue(null);
    }

    @FXML
    public void initialize(){

        txtSelectBook.setItems(FXCollections.observableArrayList(BookStore.books));
        txtSelectMemeber.setItems(FXCollections.observableArrayList(MemberStore.members));
    }

}
