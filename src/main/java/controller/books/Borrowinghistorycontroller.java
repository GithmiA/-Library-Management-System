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

    public void loadDetails() {

        ObservableList<Borrowing> list = FXCollections.observableArrayList();

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
                        resultSet.getDate("return_date").toString(),
                        resultSet.getString("status")
                );
                list.add(borrowing);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
