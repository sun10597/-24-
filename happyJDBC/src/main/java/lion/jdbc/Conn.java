package lion.jdbc;

import java.sql.*;

public class Conn {
    private static final String URL = "jdbc:mysql://localhost:3306/liondb";
    private static final String USER = "lion";
    private static final String PASSWORD = "lion1234";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("DB 연결 중 오류 발생!" + e.getMessage());
            return null;
        }
    }
}