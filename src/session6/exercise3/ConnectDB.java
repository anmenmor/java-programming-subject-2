package session6.exercise3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection instance;

    private ConnectDB() {

    }

    public static Connection getInstance() throws SQLException {
        if (instance == null) {
            instance = DriverManager.getConnection(MYSQLDEMOConection.url, MYSQLDEMOConection.username, MYSQLDEMOConection.password);
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.close();
        }
    }

}
