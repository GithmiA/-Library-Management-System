package controller.books;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.ReturnBookDTO;

import java.sql.*;
import java.time.LocalDate;

public class Returnbookcontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public void load(String searchId) {

        String SQL_1 = "SELECT * FROM members INNER JOIN borrowing ON members.member_id = borrowing.member_id WHERE borrowing.book_id = ? AND borrowing.return_date IS NULL";

        try {
            PreparedStatement preparedStatement_1 = connection.prepareStatement(SQL_1);
            preparedStatement_1.setString(1,searchId);
            ResultSet resultSet_1 = preparedStatement_1.executeQuery();

            while (resultSet_1.next()) {
                setStatus(searchId,resultSet_1.getString("due_date"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String SQL_2 = "SELECT * FROM members INNER JOIN borrowing ON members.member_id = borrowing.member_id WHERE borrowing.book_id = ? AND borrowing.return_date IS NULL;";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_2);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                ReturnBookDTO returnBookDTO = new ReturnBookDTO();

                returnBookDTO.setMemberId(resultSet.getString("member_id"));
                returnBookDTO.setFullName(resultSet.getString("full_name"));
                returnBookDTO.setPhoneNumber(resultSet.getString("phone_number"));
                returnBookDTO.setBookTitle(resultSet.getString("book_title"));
                returnBookDTO.setIssueDate(resultSet.getDate("issue_date").toString());
                returnBookDTO.setDueDate(resultSet.getDate("due_date").toString());
                returnBookDTO.setStatus(resultSet.getString("status"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setStatus(String searchId,String dueDate) {
        LocalDate today = LocalDate.now();

        String SQL_2 = "UPDATE borrowing SET status = ? WHERE " + "book_id = ? AND borrowing.return_date IS NULL;";

        if(LocalDate.parse(dueDate).isBefore(today)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_2);
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
