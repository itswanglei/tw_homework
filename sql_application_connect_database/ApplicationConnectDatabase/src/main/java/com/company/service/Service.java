package main.java.com.company.service;

import java.sql.*;

public class Service {
    private static final String URL = "jdbc:mysql://localhost:3306/student_examination_sys?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0717";

    public void selectData() throws SQLException {
        Connection connection = this.getConnect(URL, USERNAME, PASSWORD);
        Statement statement = this.getStatement(connection);
        ResultSet resultSet = this.executeSQL(statement);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        }
    }

    private Connection getConnect(String url, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver!");
            e.printStackTrace();
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Failed to get connection!");
            e.printStackTrace();
        }

        return connection;
    }

    private Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Failed to create statement!");
            e.printStackTrace();
        }
        return statement;
    }

    private ResultSet executeSQL(Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM student");
        } catch (SQLException e) {
            System.out.println("Failed to execute SQL!");
            e.printStackTrace();
        }
        return resultSet;
    }
}
