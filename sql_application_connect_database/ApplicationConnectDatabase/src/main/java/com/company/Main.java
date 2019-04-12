package main.java.com.company;

import main.java.com.company.service.Service;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        try {
            service.selectData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
