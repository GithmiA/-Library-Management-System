package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Book;
import model.BookStore;

import java.io.IOException;

public class addbookcontroller {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnBackDashboard;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPublishYear;

    @FXML
    private TextField txtQuantity;

    @FXML
    void addBookOnAction(ActionEvent event) {
        String bookId = txtBookId.getText();
        String bookTitle = txtBookTitle.getText();
        String author = txtAuthor.getText();
        String category = txtCategory.getText();
        String publishedYear = txtPublishYear.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());

        Book book = new Book(bookId,bookTitle,author,category,publishedYear,quantity);

        BookStore.books.add(book);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Book Added Successfully!");
        alert.showAndWait();

        clearField();

    }

    private void clearField() {
        txtBookId.clear();
        txtBookTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        txtPublishYear.clear();
        txtQuantity.clear();
    }

    @FXML
    void backDashboardOnAction(ActionEvent event) {
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
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/addbook_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

}
