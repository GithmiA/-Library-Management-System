package controller;

import db.DBConnection;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class logincontroller {

    DBConnection dbConnection  = DBConnection.getInstance();
    Connection connection = dbConnection.getConnection();

    public boolean nameandpasswordcheck(String name, String password) {

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
