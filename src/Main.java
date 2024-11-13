import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://127.0.0.1:3307/mydatabase";  // Corrected URL format
    static String username = "root";
    static String password = "arun";
    static String query = "UPDATE employees " +
            "SET salary = 8000.0, name = 'akash' " +
            "WHERE id = 1";


    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");

        }

        try {
            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Create a statement and execute the query
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            // Check if rows were affected
            if (rowsAffected > 0) {
                System.out.println("Query Updated successfully. Rows deleted: " + rowsAffected);
            } else {
                System.out.println("No rows were updated.");
            }

            // Close resources
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error establishing connection to the database.");

        }
    }
}
