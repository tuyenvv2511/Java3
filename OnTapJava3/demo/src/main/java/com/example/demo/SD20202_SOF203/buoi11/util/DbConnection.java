package com.example.demo.SD20202_SOF203.buoi11.util;
    import java.sql.*;

public class DbConnection {
    private static Connection conn;

    public static Connection getConnection()
    {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "sa", dbPass = "123",
                        dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=SD20202;encrypt=true;trustServerCertificate=true;";

                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {
        System.out.println(com.example.demo.SD20202_SOF203.buoi9.util.DbConnection.getConnection());
    }
}
