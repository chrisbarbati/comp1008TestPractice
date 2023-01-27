package com.example.testpractice;

public class Main {
    /**
     * Christian Barbati - 200390696
     * COMP1008 Practice
     * Bank account program.
     */
    public static void main(String[] args) {
        //Create a new customer object "Dave", and add customer info
        Customer dave = new Customer(1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996");

        //Create a new customer object "Mike", and add customer info
        Customer mike = new Customer(4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998");


        //Create a new chequing account for Dave. Account starts at $0 balance
        //Account daveChequing = new Account( 1, 1, "Chequing");

        dave.openAccount("Chequing");

        mike.openAccount("Savings");

        //Displays which customer numbers have been assigned
        //System.out.println(dave.displayAssignedCustomerNumbers());
    }
}
