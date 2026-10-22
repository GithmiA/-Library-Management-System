package controller.books;

import db.DBConnection;
import model.Book;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Issuebookcontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String SQL = "SELECT * FROM books";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getString("book_id"));
                book.setBookTitle(resultSet.getString("book_title"));

                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;

    }

    public List<Member> getAllMembers() {

        List<Member> members = new ArrayList<>();

        String SQL = "SELECT * FROM members;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberId(resultSet.getString("member_id"));
                member.setFullName(resultSet.getString("full_name"));

                members.add(member);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;

    }


}
