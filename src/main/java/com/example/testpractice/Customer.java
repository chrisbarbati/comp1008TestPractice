package com.example.testpractice;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Bank customer class.
     */

    /**
     * List that holds each Customer object
     */
    static ArrayList<Customer> customersList = new ArrayList<>();

    /**
     * Instance List for each customer, that holds his / her accounts
     */
    ArrayList<Account> customersAccounts = new ArrayList<>();

    /**
     * Other instance variables
     */
    private int customerNumber, customerPIN;
    private String firstName, lastName, address, dateOfBirth;
    private Image customerImage;

    public Customer(Image customerImage, int customerNumber, int customerPIN, String firstName, String lastName, String address, String dateOfBirth){
        setCustomerImage(customerImage);

        setCustomerNumber(customerNumber);

        setCustomerPIN(customerPIN);

        setFirstName(firstName);

        setLastName(lastName);

        setAddress(address);

        setDateOfBirth(dateOfBirth);

        //Only prints for customer numbers > 0, so no output is printed for dummy customer.
        if(customerNumber > 0) {
            System.out.println("\nNew customer created. \nCustomer Number: " + customerNumber + " \nPIN: " + customerPIN
                    + " \nName: " + firstName + " " + lastName + " \nAddress: " + address + " \nDOB: " + dateOfBirth + "\n");
        }
    }

    public Image getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(Image customerImage) {
        this.customerImage = customerImage;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     *
     * @param customerNumber
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getCustomerPIN() {
        return customerPIN;
    }

    /**
     *
     * @param customerPIN must be four digits. Must be numeric only.
     */
    public void setCustomerPIN(int customerPIN) {
        this.customerPIN = customerPIN;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName customer's first name. Must have more than two non-whitespace characters.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName customer's last name. Must have more than two non-whitespace characters.
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

    /**
     * Function to open a new account. Takes a string accountType as it's argument, and calls the appropriate constructor.
     * Add functionality to make function case-insensitive
     *
     * @param accountType
     */
    public void openAccount(String accountType){
        //Add account to both accountList and customer's list

        if(accountType.equals("Chequing")){
            Account.accountsList.add(new Chequing());
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }else if(accountType.equals("Savings")){
            Account.accountsList.add(new Savings());
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }else if(accountType.equals("TFSA")){
            Account.accountsList.add(new TFSA());
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }else{
            throw new IllegalArgumentException(accountType + " is not a valid selection. Valid types are Chequing, Savings, and TFSA.");
        }

    }
}
