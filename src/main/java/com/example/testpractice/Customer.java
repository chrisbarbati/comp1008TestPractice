package com.example.testpractice;

import javafx.scene.image.Image;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    /**
     * Default constructor. Requires image, customer number, PIN, names (first and last), address, DOB
     * @param customerImage
     * @param customerNumber
     * @param customerPIN
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     */
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
     *  Customer numbers cannot be negative.
     * @param customerNumber
     */
    public void setCustomerNumber(int customerNumber) {
        if(customerNumber >= 0){
            this.customerNumber = customerNumber;
        }else{
            throw new IllegalArgumentException("Customer numbers must be zero or greater.");
        }
    }

    public int getCustomerPIN() {
        return customerPIN;
    }

    /**
     * @param customerPIN must be 4 digits long, must be greater than zero, must not be one of the common passwords.
     */
    public void setCustomerPIN(int customerPIN) {
        if(customerPIN > 0 && customerPIN < 9999 ){
            this.customerPIN = customerPIN;
        }else if(customerPIN == 1234 || customerPIN == 4321 || customerPIN == 0000){
            throw new IllegalArgumentException("Insecure PIN. Please try again.");
        }
        else{
            throw new IllegalArgumentException("PIN must be in the range 0 - 9999");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName customer's first name. Must have more than two non-whitespace characters.
     */
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if(firstName.length() > 2) {
            this.firstName = firstName;
        }else{
            throw new IllegalArgumentException("Name must have at least two non-whitespace characters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName customer's last name. Must have more than two non-whitespace characters.
     */
    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if(lastName.length() > 2) {
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Name must have at least two non-whitespace characters");
        }
    }

    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address customer's address.
     *
     *                Regex Pattern: Must not have special characters. Alphanumeric only. Length and format not
     *                tested, due to variety of addresses.
     *
     *                Come back to this later and add Regex
     */
    public void setAddress(String address) {
            this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth customer's DOB. Must take form MM-DD-YYYY. Found that the Date import has some useful functions for this
     */
    public void setDateOfBirth(String dateOfBirth) {
        LocalDate dob;
        DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        try{
            dob = LocalDate.parse(dateOfBirth, dobFormat);
            this.dateOfBirth = dateOfBirth;
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date. Date must take format MM-DD-YYYY.");
        }

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
            throw new IllegalArgumentException("Valid types are Chequing, Savings, and TFSA.");
        }

    }
}
