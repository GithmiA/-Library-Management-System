package controller.members;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Addmembercontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public void addMember(MemberDTO memberDTO) {

        String SQL = "INSERT INTO members(member_id,full_name,email,phone_number,address) VALUES (?,?,?,?,?);";

        PreparedStatement preparedStatement;

        {
            try {
                preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1,memberDTO.getMemberId());
                preparedStatement.setString(2, memberDTO.getFullName());
                preparedStatement.setString(3, memberDTO.getEmail());
                preparedStatement.setString(4, memberDTO.getPhoneNumber());
                preparedStatement.setString(5, memberDTO.getAddress());

                preparedStatement.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Member Added Successfully!");
                alert.showAndWait();


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
