package session6.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // load and register JDBC driver for MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean timeToQuit = false;
        Connection con = null;
        try {
            con = ConnectDB.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        };
        //try-with-resources
        try  (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                timeToQuit = executeMenu(con, in);

            } while (!timeToQuit);

        } catch (IOException e) {
            System.out.println("Error " + e.getClass().getName() + " , quiting.");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error closing resource " + e.getClass().getName());
            System.out.println("Message: " + e.getMessage());
        }
        finally {
            try {
                ConnectDB.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static boolean executeMenu(Connection con, BufferedReader in) throws Exception {
        Employee emp;
        String action;
        int id;

        System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
        action = in.readLine();
        if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
            return true;
        }

        switch (action.toUpperCase().charAt(0)) {
            // Create a new employee record
            case 'C':
                emp = inputEmployee(in);
                add(emp, con);
                System.out.println("Successfully added Employee Record: " + emp.getId());
                System.out.println("\n\nCreated " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                emp = findById(id, con);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }

                break;

            // Update an existing employee record
            case 'U':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());
                // Find this Employee record
                emp = null;
                emp = findById(id, con);
                if (emp == null) {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                update(emp, con);
                System.out.println("Successfully updated Employee Record: " + emp.getId());
                break;

            // Delete an employee record
            case 'D':
                System.out.println("Enter int value for employee id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                if (delete(id, con) == 1) {
                    System.out.println("Deleted Employee " + id);
                } else {
                    System.out.println("Employee " + id + " not deleted!!!!");
                }
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Employee[] allEmps = getAllEmployees(con);
                for (Employee employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
        }

        return false;
    }

    private static Employee inputEmployee(BufferedReader in) throws IOException {
        return inputEmployee(in, null, true);
    }

    private static Employee inputEmployee(BufferedReader in, Employee empDefaults) throws IOException {
        return inputEmployee(in, empDefaults, false);
    }

    private static Employee inputEmployee(BufferedReader in, Employee empDefaults, boolean newEmployee) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("MM, dd, yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Employee emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println("Enter int value for employee id: ");
                try {
                    id = Integer.parseInt(in.readLine().trim());
                    if (id < 0) {
                        System.out.println("Please retry with a valid positive integer id");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please retry with a valid positive integer id");
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println("Modify the fields of Employee record: " + id
                    + ". Press return to accept current value.");
        }

        String prompt = "Enter value for employee first name" + ((empDefaults == null) ? "" : " [" + empDefaults.getFirstName() + "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getFirstName();
            }
            if (firstName.length() < 1) {
                System.out.println("Please retry with a valid first name");
            }
        } while (firstName.length() < 1);


        prompt = "Enter value for employee last name" + ((empDefaults == null) ? "" : " [" + empDefaults.getLastName() + "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getLastName();
            }
            if (lastName.length() < 1) {
                System.out.println("Please retry with a valid last name");
            }
        } while (lastName.length() < 1);


        prompt = "Enter value for employee birth date (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getBirthDate()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getBirthDate();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
                    System.out.println("Please retry with a valid birth date: " + e.getMessage());
                }
            }
        } while (birthDate == null);


        prompt = "Enter float value for employee salary"
                + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalary()) + "]");
        do {
            System.out.println(prompt + " : ");
            salary = 0;
            try {
                String amt = in.readLine().trim();
                if (!amt.equals("")) {
                    salary = Float.parseFloat(amt);
                }
                if (salary == 0 && empDefaults != null) {
                    salary = empDefaults.getSalary();
                }
                if (salary < 0) {
                    System.out.println("Please retry with a positive salary");
                    salary = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please retry with a valid float salary: " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Employee(id, firstName, lastName, birthDate, salary);
        return emp;
    }

    // Add an Employee record using an INSERT SQL command
    private static void add(Employee emp, Connection con) throws Exception {
        try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO EMPLOYEE VALUES (" + emp.getId() + ","
                    + "'" + emp.getFirstName() + "'," + "'" + emp.getLastName() + "',"
                    + "'" + new java.sql.Date(emp.getBirthDate().getTime()) + "'," + emp.getSalary() + ")";
            if (stmt.executeUpdate(query) != 1) {
                throw new Exception("Error adding employee");
            }
        }
    }

    // Update an employee record with a SQL UPDATE command
    private static void update(Employee emp, Connection con) throws Exception {
        String query = "UPDATE EMPLOYEE SET FIRSTNAME = ?, LASTNAME = ?, BIRTHDATE = ?, SALARY = ? WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, emp.getFirstName());
        stmt.setString(2, emp.getLastName());
        stmt.setDate(3, new java.sql.Date(emp.getBirthDate().getTime()));
        stmt.setFloat(4, emp.getSalary());
        stmt.setInt(5, emp.getId());
        if (stmt.executeUpdate() != 1) {
            throw new Exception("Error updating employee");
        }
    }

    // Delete an employee record that has this ID from the database using the DELETE command
    private static int delete(int id, Connection con) throws Exception {
        String query = "DELETE FROM EMPLOYEE WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    // Find an Employee record using this ID
    private static Employee findById(int id, Connection con) throws SQLException {
        String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Employee employee = null;
        if(rs.next()) {
            employee = new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"), rs.getFloat("SALARY"));
        }
        return employee;
    }

    // Return an array of all of the Employee records
    // We are using a collection List object to store the results
    // This makes it easier to just add to the collection
    private static Employee[] getAllEmployees(Connection con) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int empID = rs.getInt("ID");
            String first = rs.getString("FIRSTNAME");
            String last = rs.getString("LASTNAME");
            java.sql.Date birth_date = rs.getDate("BIRTHDATE");
            float salary = rs.getFloat("SALARY");
            Employee employee = new Employee(empID, first, last, birth_date, salary);
            employees.add(employee);
        }
        Employee[] arr = employees.toArray(new Employee[employees.size()]);
        return arr;
    }
}

