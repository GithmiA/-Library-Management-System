package controller.books;

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
import java.util.List;
import java.awt.*;
import java.io.IOException;

public class Issuebookpagecontroller {

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

    Issuebookcontroller issuebookcontroller = new Issuebookcontroller();

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
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/issuebook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void issueBookOnAction(ActionEvent event) {

        if( (txtSelectBook.getValue() != null) && (txtSelectMemeber.getValue() != null) ) {
            issuebookcontroller.issueBook(
                    txtSelectMemeber.getValue().getMemberId(),
                    txtSelectMemeber.getValue().getFullName(),
                    txtSelectBook.getValue().getBookId(),
                    txtSelectBook.getValue().getBookTitle(),
                    txtIssueBook.getValue(),
                    txtDueDate.getValue()
            );

        }
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
        List<Book> books = issuebookcontroller.getAllBooks();
        List<Member> members = issuebookcontroller.getAllMembers();

        txtSelectBook.getItems().addAll(books);
        txtSelectMemeber.getItems().addAll(members);
    }

}
