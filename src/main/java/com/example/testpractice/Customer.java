package com.example.testpractice;

public class Customer {
    /**
     * Bank customer class.
     */
    private int customerNumber, customerPIN;
    private String firstName, lastName, address, dateOfBirth;

    public Customer(int customerNumber, int customerPIN, String firstName, String lastName, String address, String dateOfBirth){
        setCustomerNumber(customerNumber);

        setCustomerPIN(customerPIN);

        setFirstName(firstName);

        setLastName(lastName);

        setAddress(address);

        setDateOfBirth(dateOfBirth);

        System.out.println("\nNew customer created. \nCustomer Number: " + customerNumber + " \nPIN: "+ customerPIN
        + " \nName: " + firstName + " " + lastName + " \nAddress: " + address + " \nDOB: " + dateOfBirth + "\n");
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
         Main.accounts.add(new Account(customerNumber, accountType));
    }
}
