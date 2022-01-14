package com.laptrinhjavaweb.utils;

import java.sql.*;

public class SqlUtils {
    private final static String DB_URL = "jdbc:mysql://localhost:3307/db_support_tan";
    private final static String USER = "root";
    private final static String PASS = "password";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Could not get connection!");
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String buildQueryUsingLike(String column, String value) {
        return (!ValidateUtils.isValid(value)) ? ""
                : String.format(" AND %s LIKE %s", column, "'%" + value + "%'");
    }

    public static String buildQueryUsingOperator(String column, Object value, String operator) {
        if (!ValidateUtils.isValid(value)) return "";

        return (value instanceof String) ? String.format(" AND %s %s '%s'", column, operator, value)
                : String.format(" AND %s %s %s", column, operator, value);
    }

    public static String buildQueryUsingBetween(String column, Object from, Object to) {
        if (null == from && null == to) return "";
        else {
            if (null == from) from = 0;
            if (null == to) {
                if (from instanceof Integer) {
                    to = Integer.MAX_VALUE;
                } else if (from instanceof Double) {
                    to = Double.MAX_VALUE;
                }
            }

            return String.format(" AND %s BETWEEN %s AND %s", column, from, to);
        }
    }
}
