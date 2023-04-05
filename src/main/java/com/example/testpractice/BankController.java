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
import javafx.scene.paint.Color;

public class BankController implements Initializable{
        /*
      Christian Barbati - 200390696
      COMP1008 Practice
      Bank account program.
     */

    /**
     * Variables to hold current customer, current account
     */

    private int currentCust, currentAccount = 1;

    ArrayList<Label> accountLabels = new ArrayList<>();

    @FXML
    private Button accountBackButton;

    @FXML
    private Button accountForwardButton;

    @FXML
    private TextField accountTypeField;

    @FXML
    private VBox accountsDisplayer;

    @FXML
    private ScrollPane accountsPane;

    @FXML
    private Button addAccountButton;

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
    private TextField depositAmt;

    @FXML
    private Button depositConfirm;

    @FXML
    private TextField dobTextField;

    @FXML
    private TextField eftAmount;

    @FXML
    private Button eftConfirmation;

    @FXML
    private TextField eftRecipientNum;

    @FXML
    private TextField eftSenderNum;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button forwardButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField pinTextField;

    @FXML
    private Label selectedAcct;

    @FXML
    private TextField withdrawalAmt;

    @FXML
    private Button withdrawalConfirm;

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
        if(currentCust < (Customer.customersList.size() - 1)) {
            System.out.println("next customer");
            currentCust += 1;
            updateCustomer();
            updateAccounts();
        }
    }

    private void backButtonPressed(){
        if(currentCust > 1) {
            System.out.println("previous customer");
            currentCust -= 1;
            updateCustomer();
            updateAccounts();
        }
    }

    private void acctForward(){
        System.out.println("Account forward");
    }

    private void acctBack(){
        System.out.println("Account back");
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
            String accountInformation = "Account Number: " + account.getAccountNumber() + " Type: " + account.getAccountType() + "Balance: " + account.getBalance();
            accountLabels.add(new Label(accountInformation));
            /* Revisit this. Used to highlight the currently selected acct in the scrollpane.
            if(account.getAccountNumber() == 1) {
                accountLabels.get(accountLabels.size()).setStyle("-fx-color-label-visible: #000000;");
            } */

        }
        accountsDisplayer.getChildren().setAll(accountLabels);
    }

    private void electronicFundsTransfer(){
        Account.fundsTransfer(Double.parseDouble(eftAmount.getText()),
                Integer.parseInt(eftSenderNum.getText()),
                Integer.parseInt(eftRecipientNum.getText()));
        System.out.println("EFT Confirmed");
    }

    private void deposit(){
        Account.accountsList.get(currentAccount).deposit(Double.parseDouble(depositAmt.getText()));
        System.out.println("Deposit");
    }

    private void withdraw(){
        Account.accountsList.get(currentAccount).withdraw(Double.parseDouble(withdrawalAmt.getText()));
        System.out.println("Withdrawal");
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
         * Set the listeners for the buttons. To keep things clean, each calls it's own separate function
         * with the code within. May be more efficient to just call the functions in the other class directly,
         * but will investigate that later.
         */
        addCustomerButton.setOnMouseClicked(event -> addCustomer());
        forwardButton.setOnMouseClicked(event -> nextButtonPressed());
        backButton.setOnMouseClicked(event -> backButtonPressed());
        accountForwardButton.setOnMouseClicked(event -> acctForward());
        accountBackButton.setOnMouseClicked(event -> acctBack());
        eftConfirmation.setOnMouseClicked(event -> electronicFundsTransfer());
        depositConfirm.setOnMouseClicked(event -> deposit());
        withdrawalConfirm.setOnMouseClicked(event -> withdraw());
        addAccountButton.setOnMouseClicked(event -> addCustomer());

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

        updateAccounts();
    }
}