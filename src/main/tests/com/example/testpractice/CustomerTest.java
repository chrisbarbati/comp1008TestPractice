package com.example.testpractice;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;


    @Before
    public void setUp() throws Exception {
        BankApplication.main(new String[1]);

        //Should add new customer at index 4, since above line runs the Initialize method
        //Tests will need to be checked if more customers are added to the Initialize method later on
        customer = new Customer("portrait1.jpg", Customer.customersList.size(), 1932, "John", "Tester", "123 Fake St", "01-01-1900");
    }

    @Test
    public void getCustomerNumber() {
        assertEquals(4, customer.getCustomerNumber());
    }

    @Test
    public void setCustomerNumber() {
        customer.setCustomerNumber(5);
        assertEquals(5, customer.getCustomerNumber());
    }

    @Test
    public void setCustomerNumberInvalid() {;
        assertThrows(IllegalArgumentException.class, () -> {customer.setCustomerNumber(-10);});
    }

    @Test
    public void getCustomerPIN() {
        assertEquals(1932, customer.getCustomerPIN());
    }

    @Test
    public void setCustomerPIN() {
        customer.setCustomerPIN(1928);
        assertEquals(1928, customer.getCustomerPIN());
    }

    @Test
    public void setCustomerPINInvalid() {
        assertThrows(IllegalArgumentException.class, () ->{customer.setCustomerPIN(1234);});
        assertThrows(IllegalArgumentException.class, () ->{customer.setCustomerPIN(-1);});
        assertThrows(IllegalArgumentException.class, () ->{customer.setCustomerPIN(10000);});
    }

    @Test
    public void getFirstName() {
        assertEquals("John", customer.getFirstName());
    }

    @Test
    public void setFirstName() {
        customer.setFirstName("James");
        assertEquals("James", customer.getFirstName());
    }

    @Test
    public void setFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () ->{customer.setFirstName("1234");});
    }

    @Test
    public void setLastNameInvalid() {
        assertThrows(IllegalArgumentException.class, () ->{customer.setLastName("1234");});
    }

    @Test
    public void getLastName() {
        assertEquals("Tester", customer.getLastName());
    }

    @Test
    public void setLastName() {
        customer.setLastName("Testerson");
        assertEquals("Testerson", customer.getLastName());
    }

    @Test
    public void getAddress() {
        assertEquals("123 Fake St", customer.getAddress());
    }

    @Test
    public void setAddress() {
        customer.setAddress("321 -,.' Fake St");
        assertEquals("321 -,.' Fake St", customer.getAddress());
    }

    @Test
    public void setAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {customer.setAddress("@#$%$");});
    }

    @Test
    public void getDateOfBirth() {
        assertEquals("01-01-1900", customer.getDateOfBirth());
    }

    @Test
    public void setDateOfBirth() {
        customer.setDateOfBirth("02-02-1900");
        assertEquals("02-02-1900", customer.getDateOfBirth());
    }

    @Test
    public void setDateOfBirthInvalid() {
        assertThrows(IllegalArgumentException.class, () ->{customer.setDateOfBirth("01-01-2015");});
        assertThrows(IllegalArgumentException.class, () ->{customer.setDateOfBirth("01-01-1850");});
        assertThrows(IllegalArgumentException.class, () ->{customer.setDateOfBirth("June 5th 2000");});
    }

    @Test
    public void openAccount() {
        int numOfAccounts = Account.accountsList.size();

        customer.openAccount("Chequing");

        assertEquals((numOfAccounts+1), Account.accountsList.size());
    }

}