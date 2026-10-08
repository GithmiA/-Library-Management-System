package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.time.LocalDate;

public class maindashboardcontroller {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBorrowingHistory;

    @FXML
    private Button btnIssueBook;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnManageMembers;

    @FXML
    private Button btnReturnBook;

    @FXML
    private Label lblTotalBook;

    @FXML
    private Label lblTotalMembers;

    @FXML
    private Label lblCurrentlyBorrowing;

    @FXML
    private Label lblOverdueBooks;

    @FXML
    public void initialize() {
        int totalBooks =0;

        for(Book book : BookStore.books) {
            totalBooks += book.getQuantity();
        }
        lblTotalBook.setText(String.valueOf(totalBooks));

        int totalMembers = MemberStore.members.size();
        lblTotalMembers.setText(String.valueOf(totalMembers));

        int currentlyBorrowing = 0;
        int overdueBooks = 0;

        LocalDate today = LocalDate.now();
        for (Borrowing borrowing : BorrowingStore.borrowings){
            if (borrowing.getStatus().equals("Borrowed")) {
                currentlyBorrowing++;
                LocalDate dueDate = LocalDate.parse(borrowing.getDueDate());
                if(dueDate.isBefore(today)) {
                    overdueBooks++;
                }
            }
        }
        lblCurrentlyBorrowing.setText(String.valueOf(currentlyBorrowing));
        lblOverdueBooks.setText(String.valueOf(overdueBooks));
    }




    @FXML
    void addBookOnActoin(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/addbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void addMemberOnActoin(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/addmember_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void borrowingHistoryOnAction(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/borrowinghistory_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void issueBookOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/issuebook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void logoutOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/login_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void manageMemberOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/managemember_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();


    }

    @FXML
    void returnBookOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/returnbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}
