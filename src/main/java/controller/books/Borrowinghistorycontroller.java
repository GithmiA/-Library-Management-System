package controller.books;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Borrowing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Borrowinghistorycontroller {

     Connection connection = DBConnection.getInstance().getConnection();

    ObservableList<Borrowing> list = FXCollections.observableArrayList();

    public ObservableList<Borrowing> loadDetails() {



        String SQL = "SELECT * FROM borrowing;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Borrowing borrowing = new Borrowing(
                        resultSet.getString("member_id"),
                        resultSet.getString("book_title"),
                        resultSet.getDate("issue_date").toString(),
                        resultSet.getDate("due_date").toString(),
                        resultSet.getString("status")
                );
                String returnDate = resultSet.getString("return_date");
                if (returnDate == null) {
                    borrowing.setReturnDate(" - ");
                }else {
                    borrowing.setReturnDate(resultSet.getString("return_date"));
                }
                list.add(borrowing);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Borrowing> searchData(String searchId) {

        String SQL = "SELECT * FROM borrowing WHERE borrowing.member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Borrowing borrowing = new Borrowing(
                        resultSet.getString("member_id"),
                        resultSet.getString("book_title"),
                        resultSet.getDate("issue_date").toString(),
                        resultSet.getDate("due_date").toString(),
                        resultSet.getString("status")
                );

                String returnDate = resultSet.getString("return_date");
                if (returnDate == null) {
                    borrowing.setReturnDate(" - ");
                }else {
                    borrowing.setReturnDate(resultSet.getString("return_date"));
                }
                list.add(borrowing);

            }
            return list;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
