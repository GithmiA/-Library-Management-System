package controller.login;

import db.DBConnection;

import java.sql.*;

public class logincontroller {


    Connection connection = DBConnection.getInstance().getConnection();

    public boolean nameandpasswordcheck(String name, String password) {

        System.out.println(connection);
        String SQL = "SELECT * FROM users;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                if(name.equals(dbUsername) && password.equals(dbPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }
}
