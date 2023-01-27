package com.example.testpractice;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerNumber, customerPIN;

    private static int currentCustomerNumber = 0;

    static ArrayList<String> validCustomerNumber = new ArrayList<String>();
    private String firstName, lastName, address, dateOfBirth;

    public Customer(int customerPIN, String firstName, String lastName, String address, String dateOfBirth) {

        /**
         * Increment the current customer number by one, and assign it to the customer we are constructing
         */
        currentCustomerNumber++;
        setCustomerNumber(currentCustomerNumber);

        setCustomerPIN(customerPIN);

        setFirstName(firstName);

        setLastName(lastName);

        setAddress(address);

        setDateOfBirth(dateOfBirth);

        System.out.println("\nNew customer created. \nNumber: " + customerNumber + " \nPIN: "+ customerPIN
        + " \nName: " + firstName + " " + lastName + " \nAddress: " + address + " \nDOB: " + dateOfBirth);
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     *
     * @param currentCustomerNumber must be greater than 0, must be unique, must be assigned sequentially.
     */
    public void setCustomerNumber(int currentCustomerNumber) {
        this.customerNumber = currentCustomerNumber;
        validCustomerNumber.add(Integer.toString(this.customerNumber));
    }

    public int getCustomerPIN() {
        return customerPIN;
    }

    /**
     *
     * @param customerPIN must be four digits.
     */
    public void setCustomerPIN(int customerPIN) {
        this.customerPIN = customerPIN;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName customer's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName customer's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address customer's address. Maybe break this into multiple fields later (house number, street name,
     *                province, etc). For now K.I.S.S.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth customer's DOB. Maybe break this into multiple fields later (day, month, year). For now,
     *                    K.I.S.S
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public static ArrayList displayAssignedCustomerNumbers(){
        return validCustomerNumber;
    }
}
