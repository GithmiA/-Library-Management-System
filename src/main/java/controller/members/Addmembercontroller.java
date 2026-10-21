package controller.members;

import db.DBConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Addmembercontroller {

    Connection connection = DBConnection.getInstance().getConnection();

    public void addMember(String memberId,String name,String memberEmail,String phoneNumber,String memberAddress) {

        String SQL = "INSERT INTO members(member_id,full_name,email,phone_number,address) VALUES (?,?,?,?,?);";

        PreparedStatement preparedStatement;

        {
            try {
                preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1,memberId);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,memberEmail);
                preparedStatement.setString(4,phoneNumber);
                preparedStatement.setString(5,memberAddress);

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
