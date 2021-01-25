package practice3;

import practice3.model.Character;
import practice3.model.DBManager;
import practice3.model.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        FightGame programa;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = ConnectDB.getInstance();
            programa = new FightGame(con);
            programa.menu();

        } catch (Exception e) {
            System.out.println("Error closing resource "+ e.getClass().getName());
            System.out.println("Message: "+e.getMessage());
        }finally {
            try {
                ConnectDB.closeConnection();
            } catch (SQLException e) {
                System.out.println("Error closing resource "+e.getClass().getName());
            }
        }
    }
}
