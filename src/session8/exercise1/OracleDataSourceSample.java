package session8.exercise1;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import session8.utilities.*;


public class OracleDataSourceSample
{
    public static void main (String[] args){
        try {
            System.setProperty("oracle.net.tns_admin", "src\\Oracle_Wallet");
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (OracleConnection connection = (OracleConnection) ConnectDB.getInstance()) {
                setTypeMap(connection);
                /*printBooks(connection);
                int location = 4;
                Book book = new Book("4443095689", "Platero y yo", "Juan Ramón Jiménez", 5);
                insertBook(connection, location, book);*/
                printBooks(connection);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setTypeMap(OracleConnection connection) throws ClassNotFoundException, SQLException{
        java.util.Map map = connection.getTypeMap();
        if (!map.containsKey("BOOK")){
            map.put("BOOK", Book.class);
            connection.setTypeMap(map);
        }
    }

    private static void printBooks(OracleConnection connection) throws SQLException, ClassNotFoundException {
        try (Statement statement = connection.createStatement()) {
            try (ResultSet rset = statement.executeQuery("select BOOK from library")) {
                System.out.println("<----------------Library books ------------>");
                while (rset.next()) {
                    Book book = (Book) rset.getObject(1);
                    System.out.println(book.toString());
                }
                System.out.println("<------------------------------------------>");
            }
        }
    }

    private static void insertBook(OracleConnection connection, int location, Book book) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("insert into library values(?,?)")) {
                pstmt.setInt(1, location);
                pstmt.setObject(2, book);
                pstmt.executeUpdate();
            }
    }
}