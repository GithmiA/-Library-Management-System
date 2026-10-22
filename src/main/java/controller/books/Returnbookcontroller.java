package controller.books;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.ReturnBook;

import java.sql.*;
import java.time.LocalDate;

public class Returnbookcontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public ReturnBook load(String searchId) {

        String SQL = "SELECT * FROM members INNER JOIN borrowing ON members.member_id = borrowing.member_id WHERE borrowing.book_id = ? AND borrowing.return_date IS NULL;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                setStatus(searchId,resultSet.getDate("due_date").toString());

                return new ReturnBook(
                            resultSet.getString("member_id"),
                            resultSet.getString("full_name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("book_title"),
                            resultSet.getDate("issue_date").toString(),
                            resultSet.getDate("due_date").toString(),
                            resultSet.getString("status")
                            );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setStatus(String searchId,String dueDate) {

        LocalDate today = LocalDate.now();

        String SQL = "UPDATE borrowing SET status = ? WHERE book_id = ?;";


        if(LocalDate.parse(dueDate).isBefore(today)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1,"OVERDUE");
                preparedStatement.setString(2,searchId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void returnBook(LocalDate returnDate,String bookId) {

        String SQL_1 = "UPDATE borrowing SET return_date = ? WHERE book_id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_1);

            preparedStatement.setDate(1, Date.valueOf(returnDate));
            preparedStatement.setString(2,bookId);

            preparedStatement.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book Returned Successfully!");
            alert.showAndWait();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String SQL_2 = "UPDATE borrowing SET status = 'Returned' WHERE book_id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_2);
            preparedStatement.setString(1,bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
