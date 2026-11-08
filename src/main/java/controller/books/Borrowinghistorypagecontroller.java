package controller.books;

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
import model.BorrowingDTO;


import java.io.IOException;

public class Borrowinghistorypagecontroller {

    @FXML
    private TableColumn<BorrowingDTO, String> bookTitleColumn;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<BorrowingDTO, String> dueDateColumn;

    @FXML
    private TableColumn<BorrowingDTO, String> issueDateColumn;

    @FXML
    private TableColumn<BorrowingDTO, String> memberIdColumn;

    @FXML
    private TableColumn<BorrowingDTO, String> returnDateColumn;

    @FXML
    private TableColumn<BorrowingDTO, String> statusColumn;

    @FXML
    private TableView<BorrowingDTO> tblTableView;

    @FXML
    private TextField txtSearchById;

    Borrowinghistorycontroller borrowinghistorycontroller = new Borrowinghistorycontroller();
    BorrowingDTO borrowing = new BorrowingDTO();

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void searchOnAction(MouseEvent event) {
        tblTableView.getItems().clear();
        String searchId = txtSearchById.getText().trim();

        tblTableView.setItems(borrowinghistorycontroller.searchData(searchId));

    }
    @FXML
    public void initialize() {
        memberIdColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblTableView.setItems(borrowinghistorycontroller.loadDetails());

        txtSearchById.textProperty().addListener(
                (observable,oldValue,newValue) -> {
                    if (newValue == null || newValue.trim().isEmpty()) {
                        tblTableView.getItems().clear();
                        tblTableView.setItems(borrowinghistorycontroller.loadDetails());
                    }
                }
        );

    }
}
