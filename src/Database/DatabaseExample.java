package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseExample {

    public static void main(String[] args) {

        String url = "********";
        String username = "******";
        String password = "*******"; // your MySQL password

        try {
            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");

            // Create SQL statement
            Statement statement = connection.createStatement();

            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            // Display results
            System.out.println("ID\tName\t\tAge");
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id") + "\t" +
                    resultSet.getString("name") + "\t" +
                    resultSet.getInt("age")
                );
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
