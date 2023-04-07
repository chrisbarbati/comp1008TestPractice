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

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
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

    public void openAccount(String accountType){
        //Add account to both accountList and customer's list

        if(accountType.equals("Chequing")){
            Account.accountsList.add(new Chequing(customerNumber));
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }else if(accountType.equals("Savings")){
            Account.accountsList.add(new Savings(customerNumber));
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }else if(accountType.equals("TFSA")){
            Account.accountsList.add(new TFSA(customerNumber));
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
        }

    }
}
