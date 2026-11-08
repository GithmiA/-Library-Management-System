package controller.books;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.BookDTO;
import model.BorrowingDTO;
import model.MemberDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class Issuebookcontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public List<BookDTO> getAllBooks() {

        List<BookDTO> books = new ArrayList<>();

        String SQL = "SELECT * FROM books";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookDTO book = new BookDTO();
                book.setBookId(resultSet.getString("book_id"));
                book.setBookTitle(resultSet.getString("book_title"));

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;

    }

    public List<MemberDTO> getAllMembers() {

        List<MemberDTO> members = new ArrayList<>();

        String SQL = "SELECT * FROM members;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MemberDTO member = new MemberDTO();
                member.setMemberId(resultSet.getString("member_id"));
                member.setFullName(resultSet.getString("full_name"));

                members.add(member);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;

    }
    public void issueBook(BorrowingDTO borrowingDTO) {

        String SQL = "INSERT INTO borrowing(member_id,full_name,book_id,book_title,issue_date,due_date) VALUES (?,?,?,?,?,?);";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,borrowingDTO.getMemberId());
            preparedStatement.setString(2,borrowingDTO.getFullName());
            preparedStatement.setString(3,borrowingDTO.getBookId());
            preparedStatement.setString(4, borrowingDTO.getBookTitle());
            preparedStatement.setDate(5, Date.valueOf(borrowingDTO.getIssueDate()));
            preparedStatement.setDate(6,Date.valueOf(borrowingDTO.getDueDate()));


            preparedStatement.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Book issued Successfully!");
            alert.showAndWait();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
