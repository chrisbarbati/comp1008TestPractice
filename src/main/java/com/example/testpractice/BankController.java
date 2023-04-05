package com.example.testpractice;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BankController implements Initializable{
        /*
      Christian Barbati - 200390696
      COMP1008 Practice
      Bank account program.
     */

    /**
     * Variables to hold current customer, current account
     */

    int currentCust, currentAccount;

    ArrayList<Label> accountLabels = new ArrayList<>();

    @FXML
    private ScrollPane accountsPane;

    @FXML
    private VBox accountsDisplayer;

    @FXML
    private Button addCustomerButton;

    @FXML
    private TextField addressTextField;

    @FXML
    private Button backButton;

    @FXML
    private Label custAccountLabel;

    @FXML
    private Label custAddressLabel;

    @FXML
    private Label custDOBLabel;

    @FXML
    private Label custNameLabel;

    @FXML
    private Label custNumLabel;

    @FXML
    private ImageView customerImageView;

    @FXML
    private TextField dobTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button forwardButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField pinTextField;

    private void addCustomer(){
        System.out.println("add customer");
        Customer.customersList.add(
                new Customer(
                        Customer.customersList.size(),
                        Integer.parseInt(pinTextField.getText()),
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        addressTextField.getText(),
                        dobTextField.getText()
                ));
    }

    private void nextButtonPressed(){
        System.out.println("next customer");
        currentCust += 1;
        updateCustomer();
        updateAccounts();
    }

    private void backButtonPressed(){
        System.out.println("previous customer");
        currentCust -= 1;
        updateCustomer();
        updateAccounts();
    }

    private void updateCustomer(){
        custNumLabel.setText("Customer Number: " + Integer.toString(Customer.customersList.get(currentCust).getCustomerNumber()));
        custNameLabel.setText("Name: " + Customer.customersList.get(currentCust).getFirstName() + " " + Customer.customersList.get(currentCust).getLastName());
        custAddressLabel.setText("Address: " + Customer.customersList.get(currentCust).getAddress());
        custDOBLabel.setText(Customer.customersList.get(currentCust).getDateOfBirth());
    }

    private void updateAccounts(){
        accountLabels.clear();
        for(Account account : Customer.customersList.get(currentCust).customersAccounts){
            String accountInformation = "Account Number: " + account.getAccountNumber() + " Type: " + account.getAccountType();
            accountLabels.add(new Label(accountInformation));
        }
        accountsDisplayer.getChildren().setAll(accountLabels);
    }

    public BankController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        /**
         * List is zero-referenced, but accounts and customer numbers should start at one.
         * Fix - initiate a dummy account and customer at 0, so that all numbers can be referenced directly.
         */

        /* Temporarily commenting out test code to make things cleaner
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
         */

        /**
         * Set the listeners for the buttons
         */
        addCustomerButton.setOnMouseClicked(event -> addCustomer());
        forwardButton.setOnMouseClicked(event -> nextButtonPressed());
        backButton.setOnMouseClicked(event -> backButtonPressed());

        /**
         * Instantiate some test customers (add image functionality later).
         * Index zero is filled with a dummy-account, to make indexing more user friendly
         */
        Customer.customersList.add(new Customer(Customer.customersList.size(), 0000, "--", "--",
                "--", "--"));
        Account.accountsList.add(new Account(Account.accountsList.size()));

        //Create a new customer object "David", and store in customer list
        Customer.customersList.add(new Customer(Customer.customersList.size(), 1234, "David", "Smith",
                "742 Evergreen Terrace", "01 01 1996"));

        Customer.customersList.get(1).openAccount("Chequing");
        Customer.customersList.get(1).openAccount("Savings");
        Customer.customersList.get(1).openAccount("TFSA");
        Customer.customersList.get(1).openAccount("Savings");
        Customer.customersList.get(1).openAccount("Savings");


        //Create a new customer object "Michael" and store in customer list
        Customer.customersList.add(new Customer(Customer.customersList.size(),4321, "Michael", "Baker",
                "247 Evergreen Terrace", "01 01 1998"));

        Customer.customersList.get(2).openAccount("Savings");


        /**
         * Populate the label fields with some initial values
         */
        custNumLabel.setText("Customer Number: " + Integer.toString(Customer.customersList.get(1).getCustomerNumber()));
        custNameLabel.setText("Name: " + Customer.customersList.get(1).getFirstName() + " " + Customer.customersList.get(1).getLastName());
        custAddressLabel.setText("Address: " + Customer.customersList.get(1).getAddress());
        custDOBLabel.setText(Customer.customersList.get(1).getDateOfBirth());


    }
}