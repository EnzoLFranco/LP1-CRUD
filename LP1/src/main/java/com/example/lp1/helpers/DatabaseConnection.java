package com.example.lp1.helpers;

import java.sql.*;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/lp1";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        PreparedStatement statement = prepareStatement(sql, params);
        return statement.executeQuery();
    }

    public static int executeUpdate(String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = prepareStatement(sql, params)) {
            return statement.executeUpdate();
        }
    }

    private static PreparedStatement prepareStatement(String sql, Object... params) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        for (int index = 0; index < params.length; index++) {
            statement.setObject(index + 1, params[index]);
        }
        return statement;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
