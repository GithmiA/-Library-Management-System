package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Borrowing;
import model.BorrowingStore;
import model.Member;
import model.MemberStore;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class returnbookcontroller {

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

    private Borrowing selectedBorrowing;

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
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/returnbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void returnOnAction(ActionEvent event) {
        if(selectedBorrowing == null) {
            System.out.println("Search a borrowed book first");
            return;
        }

        if(dpReturnDate.getValue() == null) {
            System.out.println("Select return Date");
            return;
        }
        String returnDate = dpReturnDate.getValue().toString();

        selectedBorrowing.setReturnDate(returnDate);
        selectedBorrowing.setStatus("Returned");

        lblStatus.setText("Returned");
        System.out.println("Book returned successfully!");

    }

    @FXML
    void searchBook(MouseEvent event) {
        String search = txtSearchBox.getText().trim();

        if(search.isEmpty()) {
            System.out.println("enter book id");
            return;
        }
        selectedBorrowing = null;

        for(Borrowing borrowing : BorrowingStore.borrowings) {
            if (borrowing.getBookId().equalsIgnoreCase(search)) {
                if(borrowing.getStatus().equals("Borrowed")){
                    selectedBorrowing = borrowing;
                    break;
                }
            }
        }
        if(selectedBorrowing != null) {
            showBorrowingDetails();
        } else {
            System.out.println("Borrowed book not fount");
        }
    }

    private void showBorrowingDetails() {
        lblMemberId.setText(selectedBorrowing.getMemberId());
        lblFullName.setText(selectedBorrowing.getMemberName());

        for(Member member : MemberStore.members) {
            if(member.getMemberId().equals(selectedBorrowing.getMemberId())) {
        lblPhoneNumber.setText(member.getPhoneNumber());
        break;
            }
        }
        lblBookTitle.setText(selectedBorrowing.getBookTitle());
        lblBorrowedDate.setText(selectedBorrowing.getIssueDate());
        lblDueDate.setText(selectedBorrowing.getDueDate());

        LocalDate today = LocalDate.now();

        if(LocalDate.parse(selectedBorrowing.getDueDate()).isBefore(today)) {
            lblStatus.setText("OVERDUE");
        } else {
            lblStatus.setText("Borrowed");
        }
    }
}
