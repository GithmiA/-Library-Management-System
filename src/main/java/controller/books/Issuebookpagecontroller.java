package controller.books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.*;
import java.util.List;
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
    private ComboBox<BookDTO> txtSelectBook;

    @FXML
    private ComboBox<MemberDTO> txtSelectMemeber;

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

        BorrowingDTO borrowingDTO = new BorrowingDTO();

        if( (txtSelectBook.getValue() != null) && (txtSelectMemeber.getValue() != null) ) {
            borrowingDTO.setMemberId(txtSelectMemeber.getValue().getMemberId());
            borrowingDTO.setFullName(txtSelectMemeber.getValue().getFullName());
            borrowingDTO.setBookId(txtSelectBook.getValue().getBookId());
            borrowingDTO.setBookTitle(txtSelectBook.getValue().getBookTitle());
            borrowingDTO.setIssueDate(txtIssueBook.getValue().toString());
            borrowingDTO.setDueDate(txtDueDate.getValue().toString());

            issuebookcontroller.issueBook(borrowingDTO);

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
        List<BookDTO> books = issuebookcontroller.getAllBooks();
        List<MemberDTO> members = issuebookcontroller.getAllMembers();

        txtSelectBook.getItems().addAll(books);
        txtSelectMemeber.getItems().addAll(members);
    }

}
