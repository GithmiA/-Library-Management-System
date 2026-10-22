package controller.books;

import db.DBConnection;
import model.ReturnBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Returnbookcontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public ReturnBook load(String searchId) {

        String SQL = "SELECT * FROM members INNER JOIN borrowing ON members.member_id = borrowing.member_id WHERE borrowing.book_id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                return new ReturnBook(
                            resultSet.getString("member_id"),
                            resultSet.getString("full_name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("book_title"),
                            resultSet.getDate("issue_date").toString(),
                            resultSet.getDate("due_date").toString()
                            );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnBook() {

        //String SQL = "";

    }

}
