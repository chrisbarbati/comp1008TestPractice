package com.example.testpractice;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BankController implements Initializable{
        /*
      Christian Barbati - 200390696
      COMP1008 Practice
      Bank account program.
     */

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Label displayBox;

    public BankController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {


        /**
         * List is zero-referenced, but accounts and customer numbers should start at one.
         * Fix - initiate a dummy account and customer at 0, so that all numbers can be referenced directly.
         */
        Customer.customersList.add(new Customer(Customer.customersList.size(), 0000, "--", "--",
                "--", "--"));
        Account.accountsList.add(new Account(Account.accountsList.size()));

        //Create a new customer object "David", and store in customer list
        Customer.customersList.add(new Customer(Customer.customersList.size(), 1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996"));

        //Create a new customer object "Michael" and store in customer list
        Customer.customersList.add(new Customer(Customer.customersList.size(),4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998"));

        //Create new accounts for the instantiated objects
        Customer.customersList.get(1).openAccount("Chequing");
        Customer.customersList.get(1).openAccount("Savings");
        Customer.customersList.get(2).openAccount("Chequing");
        Customer.customersList.get(2).openAccount("TFSA");

        //Balance check function
        System.out.println("The balance of account 1 is " + String.format("$%.2f", Account.accountsList.get(1).getBalance()) + "\n");

        //Deposit and withdrawal functions
        double amount = 20;
        Account.accountsList.get(0).deposit(amount);
        amount = 10;
        Account.accountsList.get(0).withdraw(amount);

        //Transfer function
        Account.accountsList.get(0).fundsTransfer(100.576, 1, 2);

    }
}