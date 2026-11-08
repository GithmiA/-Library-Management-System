package controller.books;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.BorrowingDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Borrowinghistorycontroller {

     Connection connection = DBConnection.getInstance().getConnection();

    ObservableList<BorrowingDTO> list = FXCollections.observableArrayList();

    public ObservableList<BorrowingDTO> loadDetails() {

        String SQL = "SELECT * FROM borrowing;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BorrowingDTO borrowingDTO = new BorrowingDTO();

                borrowingDTO.setMemberId(resultSet.getString("member_id"));
                borrowingDTO.setBookTitle(resultSet.getString("book_title"));
                borrowingDTO.setIssueDate(resultSet.getDate("issue_date").toString());
                borrowingDTO.setDueDate(resultSet.getDate("due_date").toString());
                borrowingDTO.setStatus(resultSet.getString("status"));

                if (resultSet.getString("return_date") == null) {
                    borrowingDTO.setReturnDate(" - ");
                }else {
                    borrowingDTO.setReturnDate(resultSet.getString("return_date"));
                }

                list.add(borrowingDTO);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<BorrowingDTO> searchData(String searchId) {

        String SQL = "SELECT * FROM borrowing WHERE borrowing.member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BorrowingDTO borrowingDTO = new BorrowingDTO();
                borrowingDTO.setMemberId(resultSet.getString("member_id"));
                borrowingDTO.setBookTitle(resultSet.getString("book_title"));
                borrowingDTO.setIssueDate(resultSet.getDate("issue_date").toString());
                borrowingDTO.setDueDate(resultSet.getDate("due_date").toString());
                borrowingDTO.setStatus(resultSet.getString("status"));

                if (resultSet.getString("return_date") == null) {
                    borrowingDTO.setReturnDate(" - ");
                }else {
                   borrowingDTO.setReturnDate(resultSet.getString("return_date"));
                }
                list.add(borrowingDTO);

            }
            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
