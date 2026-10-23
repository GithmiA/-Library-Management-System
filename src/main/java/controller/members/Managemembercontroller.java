package controller.members;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Managemembercontroller {

    Connection connection = DBConnection.getInstance().getConnection();


    public ObservableList<Member> loadTable() {

        ObservableList<Member> members = FXCollections.observableArrayList();


        String SQL = "SELECT * FROM members";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Member member = new Member(
                        resultSet.getString("member_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                );
                members.add(member);
            }
            return members;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editMember(Member member) {

    }

    public void updateMember() {

    }
}
