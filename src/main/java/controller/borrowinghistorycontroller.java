package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Borrowing;
import model.BorrowingStore;

import java.io.IOException;

public class borrowinghistorycontroller {

    @FXML
    private TableColumn<Borrowing, String> bookTitleColumn;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Borrowing, String> dueDateColumn;

    @FXML
    private TableColumn<Borrowing, String> issueDateColumn;

    @FXML
    private TableColumn<Borrowing, String> memberIdColumn;

    @FXML
    private TableColumn<Borrowing, String> returnDateColumn;

    @FXML
    private TableColumn<Borrowing, String> statusColumn;

    @FXML
    private TableView<Borrowing> tblTableView;

    @FXML
    private TextField txtSearchById;

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
    void searchOnAction(MouseEvent event) {
        String searchId = txtSearchById.getText().trim();

        if(searchId.isEmpty()) {
            tblTableView.setItems(FXCollections.observableArrayList(BorrowingStore.borrowings));
            return;
        }
        FXCollections.observableArrayList();

        javafx.collections.ObservableList<Borrowing> searchResult = FXCollections.observableArrayList();
        for (Borrowing borrowing : BorrowingStore.borrowings) {
            if(borrowing.getMemberId().equalsIgnoreCase(searchId)) {
                searchResult.add(borrowing);
            }
        }
tblTableView.setItems(searchResult);
    }
    @FXML
    public void initialize() {
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblTableView.setItems(FXCollections.observableArrayList(BorrowingStore.borrowings));
    }

}
