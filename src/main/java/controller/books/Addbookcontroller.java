package controller.books;

import db.DBConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Addbookcontroller {


    Connection connection = DBConnection.getInstance().getConnection();

    public void addStudent(String bookId,String bookTitle,String bookAuthor,String bookCategory,Integer bookPublishYear,Integer bookQuantity) {

        System.out.println(connection);

        String SQL = "INSERT INTO books(book_id,book_title,author,category,publish_year,quantity) VALUES (?,?,?,?,?,?);";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,bookId);
            preparedStatement.setString(2,bookTitle);
            preparedStatement.setString(3,bookAuthor);
            preparedStatement.setString(4,bookCategory);
            preparedStatement.setInt(5,bookPublishYear);
            preparedStatement.setInt(6,bookQuantity);

            preparedStatement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book Added Successfully!");
            alert.showAndWait();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
