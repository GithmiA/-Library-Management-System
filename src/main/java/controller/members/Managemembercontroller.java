package controller.members;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Managemembercontroller {

    Connection connection = DBConnection.getInstance().getConnection();


    public ObservableList<MemberDTO> loadTable() {

        ObservableList<MemberDTO> members = FXCollections.observableArrayList();


        String SQL = "SELECT * FROM members";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MemberDTO member = new MemberDTO(
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

    public void editMember(MemberDTO member) {

    }

    public void updateMember(MemberDTO member) {

        String SQL= " UPDATE members SET full_name = ?," + "email = ?,phone_number = ?" + "WHERE members.member_id =?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, member.getFullName());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPhoneNumber());
            preparedStatement.setString(4, member.getMemberId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteMember(MemberDTO member) {
        String SQL = "DELETE FROM members WHERE members.member_id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, member.getMemberId());
            int row = preparedStatement.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean hasBorrowingRecords(MemberDTO member) {

        String SQL = "SELECT 1 FROM borrowing " + "WHERE borrowing.member_id = ? LIMIT 1;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, member.getMemberId());
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public ObservableList<MemberDTO> searchDate(String searchId) {

        ObservableList<MemberDTO> list = FXCollections.observableArrayList();

        String SQL = "SELECT * FROM members WHERE members.member_id = ?;";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                MemberDTO member = new MemberDTO(
                        resultSet.getString("member_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number")
                );
                list.add(member);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
