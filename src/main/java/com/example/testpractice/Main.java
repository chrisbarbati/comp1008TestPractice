package com.example.testpractice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Christian Barbati - 200390696
     * COMP1008 Practice
     * Bank account program.
     */

    /**
     * Lists to hold our customer and account objects
     */
    static List<Customer> customers = new ArrayList<>();

    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        //Create a new customer object "David", and store in customer list
        customers.add(new Customer(customers.size()+1, 1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996"));

        //Create a new customer object "Michael" and store in customer list
        customers.add(new Customer(customers.size()+1,4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998"));

        //Create new accounts for the instantiated objects
        customers.get(0).openAccount("Chequing");
        customers.get(0).openAccount("Savings");
        customers.get(1).openAccount("Chequing");
    }
}
