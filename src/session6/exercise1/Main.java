package session6.exercise1;

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
        String url = "jdbc:://localhost:3306/mysqldemo";
        String username = "root";
        String password = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Loop
            System.out.println("Enter salary to search:");
            float employeeSalary = Float.parseFloat(in.readLine());
            String query = "SELECT * FROM Employee WHERE SALARY > ?"; //input 1 OR 1=1 returns NumberFormatException
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setFloat(1,employeeSalary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FIRSTNAME");
                String last = rs.getString("LASTNAME");
                Date birth_date = rs.getDate("BIRTHDATE");
                float salary = rs.getFloat("SALARY");
                System.out.format("Employee ID:   %s%n"
                                + "Employee Name: %s %s%n"
                                + "Birth Date:    %s%n"
                                + "Salary:        %s%n%n",
                        empID, first, last, birth_date, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void createTable(Connection con) {

        String query ="CREATE TABLE `mysqldemo`.`employee`\n" +
                "( `ID` INT NOT NULL, `FIRSTNAME` VARCHAR(50) NOT NULL , `LASTNAME` VARCHAR(50) NOT NULL\n" +
                ", `BIRTHDATE` DATE NOT NULL , `SALARY` FLOAT NOT NULL\n" +
                ", PRIMARY KEY (`ID`)) ENGINE = InnoDB;";
        try(Statement stmt = con.createStatement();)
        {
            if(!stmt.executeQuery("SHOW TABLES LIKE 'employee';").next())  {
                //create table and insert registers
                stmt.executeUpdate(query);
                stmt.executeUpdate("INSERT INTO `employee` (`ID`, `FIRSTNAME`, `LASTNAME`, `BIRTHDATE`, `SALARY`) VALUES ('1', 'Mary', 'Tonner', '1969-05-05', '18050');");
                stmt.executeUpdate("INSERT INTO `employee` (`ID`, `FIRSTNAME`, `LASTNAME`, `BIRTHDATE`, `SALARY`) VALUES ('2', 'Roger', 'Beker', '1980-06-12', '24523');");
                stmt.executeUpdate("INSERT INTO `employee` (`ID`, `FIRSTNAME`, `LASTNAME`, `BIRTHDATE`, `SALARY`) VALUES ('3', 'Tom', 'Nails', '1976-12-24', '36155');");
                stmt.executeUpdate("INSERT INTO `employee` (`ID`, `FIRSTNAME`, `LASTNAME`, `BIRTHDATE`, `SALARY`) VALUES ('4', 'Andrew', 'Berg', '1992-08-14', '52550');");
            }
        }catch(Exception ex){
            System.out.println("Error on table PRODUCTS creation:" + ex.getMessage());
        }
    }

}
