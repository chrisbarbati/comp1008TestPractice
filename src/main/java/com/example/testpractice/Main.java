package com.example.testpractice;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
      Christian Barbati - 200390696
      COMP1008 Practice
      Bank account program.
     */

    /**
     * Lists to hold our customer and account objects
     */

    static List<Customer> customers = new ArrayList<>();

    static List<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        /**
         * List is zero-referenced, but accounts and customer numbers should start at one.
         * Fix - initiate a dummy account and customer at 0, so that all numbers can be referenced directly.
         */
        customers.add(new Customer(customers.size(), 0000, "--", "--",
                "--", "--"));
        accounts.add(new Account(accounts.size(), "Chequing"));

        //Create a new customer object "David", and store in customer list
        customers.add(new Customer(customers.size(), 1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996"));

        //Create a new customer object "Michael" and store in customer list
        customers.add(new Customer(customers.size(),4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998"));

        //Create new accounts for the instantiated objects
        customers.get(1).openAccount("Chequing");
        customers.get(1).openAccount("Savings");
        customers.get(2).openAccount("Chequing");
        customers.get(2).openAccount("TFSA");

        //Balance check function
        System.out.println("The balance of account 1 is " + String.format("$%.2f", accounts.get(1).getBalance()) + "\n");

        //Deposit and withdrawal functions
        double amount = 20;
        accounts.get(0).deposit(amount);
        amount = 10;
        accounts.get(0).withdraw(amount);

        //Transfer functions. Incoming transfer
        accounts.get(0).fundsTransfer(100.576, 1, 2);
    }
}
