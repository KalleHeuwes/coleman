package de.kheuwes.coleman;

import java.sql.*;

public class JdbcAccessTest {

    public static void main(String[] args) {
        
        String databaseURL = "jdbc:ucanaccess://W://Haus//Umbauten//Solaranlage2020//Solaranlage.accdb";
         
        try (Connection connection = DriverManager.getConnection(databaseURL)) {
             
             
            String sql = "INSERT INTO Contacts (Full_Name, Email, Phone) VALUES (?, ?, ?)";
            /* 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Jim Rohn");
            preparedStatement.setString(2, "rohnj@herbalife.com");
            preparedStatement.setString(3, "0919989998");
             
            int row = preparedStatement.executeUpdate();
             
            if (row > 0) {
                System.out.println("A row has been inserted successfully.");
            }
             
             */
            sql = "SELECT * FROM Monatlich";
             
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                String datum = result.getString("datum");
                double gesamtverbrauch = result.getDouble("gesamtverbrauch");
                 
                System.out.println(datum + ", " + gesamtverbrauch);
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
