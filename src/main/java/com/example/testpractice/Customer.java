package com.example.testpractice;

import javafx.scene.image.Image;

import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.Period;
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
    private String firstName, lastName, address, imagePath, dateOfBirth;

    private LocalDate dob;

    /**
     * Default constructor. Requires image path, customer number, PIN, names (first and last), address, DOB
     * @param imagePath
     * @param customerNumber
     * @param customerPIN
     * @param firstName
     * @param lastName
     * @param address
     * @param dateOfBirth
     */
    public Customer(String imagePath, int customerNumber, int customerPIN, String firstName, String lastName, String address, String dateOfBirth){
        setCustomerImage(imagePath);

        setCustomerNumber(customerNumber);

        setCustomerPIN(customerPIN);

        setFirstName(firstName);

        setLastName(lastName);

        setAddress(address);

        setDateOfBirth(dateOfBirth);
    }

    /**
     * Static method to add a customer to the database.
     * Works agnostic of whether customer is in ArrayList,
     * so to make sure they are synchronized perhaps call them both from
     * some other method.
     *
     * @param c Customer object to be inserted.
     */
    public static void addCustomerToDB(Customer c){
        DBController.DBWrite("INSERT INTO customers (customerNum, firstName, lastName, pin, address, dob) VALUES ("
                + c.getCustomerNumber() + " , '"
                + c.getFirstName() + "' , '"
                + c.getLastName() + "' , "
                + c.getCustomerPIN() + " , '"
                + c.getAddress() + "' , '"
                + c.getDateOfBirth() + "');");
        System.out.println("Customer added to database: " + c.getCustomerNumber());
    }

    public Image getCustomerImage() {
        return new Image(imagePath);
    }

    public void setCustomerImage(String imagePath) {
        this.imagePath = imagePath;
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
        if(customerPIN > 0 && customerPIN < 9999 && !(customerPIN == 1234 || customerPIN == 4321 || customerPIN == 0000)){
            this.customerPIN = customerPIN;
        }else if (customerPIN < 0 || customerPIN > 9999 && !(customerPIN == 1234 || customerPIN == 4321 || customerPIN == 0000)){
                throw new IllegalArgumentException("PIN must be in the range 0 - 9999");
        }
        if(customerPIN == 1234 || customerPIN == 4321 || customerPIN == 0000){
            throw new IllegalArgumentException("Insecure PIN. Please try again.");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName customer's first name. Must have more than two non-whitespace characters. Must be alphabet
     *                  characters only.
     */
    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if(firstName.length() >= 2 && firstName.matches("^[A-Za-z]*$")) {
            this.firstName = firstName;
        }else{
            throw new IllegalArgumentException("Name must have at least two alphabet characters, no numeric or symbols.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName customer's last name. Must have more than two non-whitespace characters. Must be alphabet
     *                 characters only.
     */
    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if(lastName.length() >= 2 && lastName.matches("^[A-Za-z]*$")){
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("Name must have at least two alphabet characters, no numeric or symbols.");
        }
    }

    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address customer's address.
     *
     *                Regex Pattern: Must not have special characters (, . ' - allowed). Alphanumeric only. Length and format not
     *                tested, due to variety of addresses.
     */
    public void setAddress(String address) {
        if(address.matches("^[\\w\\s-.',]*$")){
            this.address = address;
        }else{
            throw new IllegalArgumentException("Invalid address, only alphanumeric and , . ' - allowed.");
        }
    }

    public String getDateOfBirth() {
        DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return dob.format(dobFormat).toString();
    }

    /**
     *
     * @param dateOfBirth customer's DOB. Must take form MM-DD-YYYY. Found that the Date import has some useful functions for this
     */
    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter dobFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        try{
            this.dob = LocalDate.parse(dateOfBirth, dobFormat);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid date. Date must take format MM-DD-YYYY.");
        }

        Period interval = Period.between(dob, LocalDate.now());

        int yearsBetween = interval.getYears();

        if(yearsBetween < 18 || yearsBetween > 130){
            throw new IllegalArgumentException("Customers must be at least 18 years old, and younger than 130.");
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
            Account.accountsList.add(new Account(accountType, customerNumber));
            this.customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));
    }
}
