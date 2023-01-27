package com.example.testpractice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Christian Barbati - 200390696
     * COMP1008 Practice
     * Bank account program.
     */

    //List to hold our customer objects
    static List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        //Create a new customer object "David", and store in customer list
        customers.add(new Customer(1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996"));

        //Create a new customer object "Michael" and store in customer list
        customers.add(new Customer(4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998"));


        //Create a new chequing account for Dave. Account starts at $0 balance
        //Account daveChequing = new Account( 1, 1, "Chequing");

        customers.get(0).openAccount("Chequing");

        customers.get(1).openAccount("Savings");

        //Displays which customer numbers have been assigned
        //System.out.println(dave.displayAssignedCustomerNumbers());
    }
}
