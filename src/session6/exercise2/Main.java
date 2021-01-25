package session6.exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class Main {
    public static void main(String[] args) {
        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/mysqldemo";
        String username = "root";
        String password = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Loop
            String query = "SELECT * FROM Employee"; //input 1 OR 1=1 returns NumberFormatException
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            String[] colNames = new String[numberOfColumns];
            String[] colTypes = new String[numberOfColumns];
            for (int i = 0; i < numberOfColumns; i++) {
                colNames[i] = rs.getMetaData().getColumnName(i+1);
                colTypes[i] = rs.getMetaData().getColumnTypeName(i+1);
            }
            for (int i = 0; i < numberOfColumns; i++) {
                System.out.println(colNames[i]+" "+colTypes[i]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}