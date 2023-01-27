package com.example.testpractice;

public class Main {
    /**
     * Christian Barbati - 200390696
     * Practice for test on Monday 30th January 2023.
     * Bank account program.
     */
    public static void main(String[] args) {
        Customer dave = new Customer(1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996\n\n");

        Customer dave2 = new Customer(4321, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996\n\n");

        Account daveChequing = new Account(0, 1, 3, "Chequing");

        //Displays which customer numbers have been assigned
        //System.out.println(dave.displayAssignedCustomerNumbers());
    }
}
