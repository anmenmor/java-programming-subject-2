package practice3.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static Connection instance;

    public static Connection getInstance() throws SQLException {
        if (instance == null) {
            instance = DriverManager.getConnection(MySqlConnection.url, MySqlConnection.username, MySqlConnection.password);
            System.out.println("Open Database");
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.close();
            System.out.println("Database closed");
        }
    }

}
