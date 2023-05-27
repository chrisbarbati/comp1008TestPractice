package com.example.testpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Separate class to interface with SQL database. Keeping these functions in their own
 * class helps keep the code in the BankController cleaner and easier to read.
 */

public class DBController {
    /**
     * Connection, Statement, and ResultSet objects
     */
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /**
     * Function to read from the SQL database.
     * @param query SQL query to be read
     * @return Returns the ResultSet
     */
    public static ResultSet DBRead(String query){
        try{
            //Passwords not secure, revise this later
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerList", "root", "root");

            //Look into Prepared Statements to prevent SQL Injection
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

        }catch(Exception e){
            System.out.println(e);
        }

        return resultSet;
    }

    /**
     * Function to write to the database.
     * @param query SQL query to be written.
     *              TODO: Look into Prepared Statements
     */
    public static void DBWrite(String query){
        try{
            //Passwords not secure, revise this later
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerList", "root", "root");

            //Look into Prepared Statements to prevent SQL Injection
            statement = connection.createStatement();

            //Static method to update a database
            statement.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    /**
     * Function to close all the objects opened earlier.
     * TODO: Find a smoother implementation, as this needs to be called after every function
     */
    public static void close(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
