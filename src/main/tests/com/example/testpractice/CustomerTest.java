package com.example.testpractice;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ResourceBundle;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;

    //Empty string array to let me call the main method in BankApplication
    String[] args = new String[1];

    @Before
    public void setUp() throws Exception {
        BankApplication.main(args);
        //Should add new customer at index 4, since above line runs the Initialize method
        //Tests will need to be checked if more customers are added to the Initialize method later on
        customer = new Customer(new Image("portrait1.jpg"), Customer.customersList.size(), 1932, "Mr.", "Tester", "123 Fake St", "01-01-1900");
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
    public void getCustomerPIN() {
        assertEquals(1932, customer.getCustomerPIN());
    }

    @Test
    public void setCustomerPIN() {
        customer.setCustomerPIN(1928);
        assertEquals(1928, customer.getCustomerPIN());
    }

    @Test
    public void getFirstName() {
        assertEquals("Mr.", customer.getFirstName());
    }

    @Test
    public void setFirstName() {
        customer.setFirstName("Mrs.");
        assertEquals("Mrs.", customer.getFirstName());
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
        customer.setAddress("321 Fake St");
        assertEquals("321 Fake St", customer.getAddress());
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
    public void openAccount() {
        int numOfAccounts = Account.accountsList.size();

        customer.openAccount("Chequing");

        assertEquals((numOfAccounts+1), Account.accountsList.size());
    }

}