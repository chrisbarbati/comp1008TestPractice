package com.example.testpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBController {
    /**
     * Connection, Statement, and ResultSet objects
     */
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

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
     *
     * Find a smoother implementation, as this needs to be called after every function
     * call for the other functions.
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
