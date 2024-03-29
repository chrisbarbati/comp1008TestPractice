package com.example.testpractice;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.sql.*;

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

    /**
     * ArrayList to hold the integer account numbers of each account belonging to the current
     * customer. Must use Integer, since Java won't let me store int primitive in an ArrayList
     * & since it is not of a fixed length, a typical array will not suffice.
     */
    ArrayList<Integer> customersAcctNums = new ArrayList<>();

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
    private TextField customerImageSrc;

    @FXML
    private ImageView customerImageView;

    @FXML
    private TextField depositAmt;

    @FXML
    private Button depositConfirm;

    @FXML
    private TextField dobTextField;

    @FXML
    private Label errorOutput;

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

    /**
     * Instantiates a new customer based on user input, and then adds it to the list of customers.
     * Also calls the addCustomerToDB() method for each new Customer object
     */
    private void addCustomer(){
        try{
            System.out.println("add customer");
            Customer.customersList.add(
                    new Customer(
                            customerImageSrc.getText(),
                            Customer.customersList.size(),
                            Integer.parseInt(pinTextField.getText()),
                            firstNameTextField.getText(),
                            lastNameTextField.getText(),
                            addressTextField.getText(),
                            dobTextField.getText()
                    ));
            Customer.customersList.get(Customer.customersList.size() - 1).addCustomerToDB();
            nextButtonPressed();
        }catch(Exception s){
            String message = s.toString();
            message = message.substring(36); //Trims out the java.lang.illegalargumentexception, leaving only the error message
            errorOutput.setText(message);
            errorOutput.setTextFill(Color.RED);
        }
    }

    /**
     * Cycles to the next customer in the list
     */
    private void nextButtonPressed(){
        if(currentCust < (Customer.customersList.size() - 1)) {
            System.out.println("next customer");
            currentCust += 1;
            updateCustomer();
            updateAccounts();
        }
    }

    /**
     * Cycles to the previous customer in the list
     */
    private void backButtonPressed(){
        if(currentCust > 1) {
            System.out.println("previous customer");
            currentCust -= 1;
            updateCustomer();
            updateAccounts();
        }
    }

    /**
     * Cycles to the next account in the customer's account list
     */
    private void acctForward(){
        if(customersAcctNums.size() > 0) {
            if (currentAccount < customersAcctNums.get(customersAcctNums.size() - 1)) {
                System.out.println("next account");
                currentAccount += 1;
                updateCustomer();
                updateAccounts();
            }
            while (!customersAcctNums.contains(currentAccount)) {
                currentAccount++;
            }
            updateAccounts();
        }
    }

    /**
     * Cyles to the previous account in the customer's account list
     */
    private void acctBack(){
        if(customersAcctNums.size() > 0) {
            if (currentAccount > customersAcctNums.get(0)) {
                System.out.println("previous account");
                currentAccount -= 1;
                updateCustomer();
                updateAccounts();
            }
            while (!customersAcctNums.contains(currentAccount)) {
                currentAccount--;
            }
            updateAccounts();
        }
    }

    /**
     * Updates the labels and image in the view for the customer
     */
    private void updateCustomer(){
        custNumLabel.setText("Customer Number: " + Integer.toString(Customer.customersList.get(currentCust).getCustomerNumber()));
        custNameLabel.setText("Name: " + Customer.customersList.get(currentCust).getFirstName() + " " + Customer.customersList.get(currentCust).getLastName());
        custAddressLabel.setText("Address: " + Customer.customersList.get(currentCust).getAddress());
        custDOBLabel.setText(Customer.customersList.get(currentCust).getDateOfBirth());
        customerImageView.setImage(Customer.customersList.get(currentCust).getCustomerImage());
    }

    /**
     * Updates the information in the view for the customer's accounts
     */
    private void updateAccounts(){
        customersAcctNums.clear();
        accountLabels.clear();
        errorOutput.setText("");

        for(Account account : Customer.customersList.get(currentCust).customersAccounts){
            customersAcctNums.add(account.getAccountNumber());
            String accountInformation = "# " + account.getAccountNumber() + ", Type: " + account.getAccountType() + ", Balance: " + String.format("$%.2f", account.getBalance()) + ", Rate: " + String.format("%.2f", account.getInterestRate()*100) + "%";
            accountLabels.add(new Label(accountInformation));
            // Revisit this. Used to highlight the currently selected acct in the scrollpane.
            if(account.getAccountNumber() == currentAccount) {
                accountLabels.get(accountLabels.size() - 1).setStyle("-fx-background-color: #CCCCCC;");
            }

        }
        Collections.sort(customersAcctNums);

        accountsDisplayer.getChildren().setAll(accountLabels);
    }

    /**
     * Deposit function - accesses the deposit function in the account class
     */
    private void deposit() {
        try {
            Account.accountsList.get(currentAccount).deposit(Double.parseDouble(depositAmt.getText()));
            System.out.println("Deposit");
            updateAccounts();
            Account.updateBalanceDB(currentAccount);
        }catch (Exception s) {
            String message = "Amount must be a number greater than zero.";
            errorOutput.setText(message);
            errorOutput.setTextFill(Color.RED);
        }
    }

    /**
     * Withdrawal function - accesses the withdrawal function in the account class
     */
    private void withdraw(){
        try{
            Account.accountsList.get(currentAccount).withdraw(Double.parseDouble(withdrawalAmt.getText()));
            System.out.println("Withdrawal");
            Account.updateBalanceDB(currentAccount);
            updateAccounts();
        }catch (Exception s) {
            String message = "Amount must be a number greater than zero, and less than account balance";
            errorOutput.setText(message);
            errorOutput.setTextFill(Color.RED);
        }
    }

    /**
     * Open account function - accesses the open account function in the account class
     */
    private void addAccount(){
        try{
            Customer.customersList.get(currentCust).openAccount(accountTypeField.getText());
            updateCustomer();
            updateAccounts();
        }catch(Exception s){
            String message = s.toString();
            message = message.substring(36); //Trims out the java.lang.illegalargumentexception, leaving only the error message
            errorOutput.setText(message);
            errorOutput.setTextFill(Color.RED);
        }
    }

    public BankController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

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
        depositConfirm.setOnMouseClicked(event -> deposit());
        withdrawalConfirm.setOnMouseClicked(event -> withdraw());
        addAccountButton.setOnMouseClicked(event -> addAccount());

        /**
         * Instantiate some test customers.
         * Index zero is filled with a dummy-account, to make indexing more user friendly. This account is not
         * accessible to the end-user
         */

        Customer.customersList.add(new Customer("portrait1.jpg", Customer.customersList.size(), 0001, "Fictional", "Fred",
                "742 Evergreen Terrace", "01-01-1990"));

        Account.accountsList.add(new Account("Chequing", 0));
        Customer.customersList.get(0).customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));

        /**
         * Though the one dummy-account above has been instantiated here in code, in real-life it would be more practical
         * to instantiate the objects from a database.
         *
         * Iterate over the database and instantiate objects from all the customers
         */

        ResultSet custResultSet = DBController.DBRead("SELECT * FROM customers");

        try{
            while(custResultSet.next()){
                Customer.customersList.add(new Customer(
                        custResultSet.getString("imagePath"),
                        Customer.customersList.size(),
                        custResultSet.getInt("pin"),
                        custResultSet.getString("firstName"),
                        custResultSet.getString("lastName"),
                        custResultSet.getString("address"),
                        custResultSet.getString("dob")));
            }
            DBController.close();
        }catch(Exception e){
            System.out.println(e);
        }

        /**
         * Iterate over the database and instantiate objects from all the accounts
         */

        ResultSet acctResultSet = DBController.DBRead("SELECT * FROM accounts");

        try{
            while(acctResultSet.next()){
                Account.accountsList.add(new Account(acctResultSet.getString("accountType"), acctResultSet.getInt("accountOwner")));
                Customer.customersList.get(acctResultSet.getInt("accountOwner")).customersAccounts.add(Account.accountsList.get(Account.accountsList.size() - 1));

                //Customer.customersList.get(acctResultSet.getInt("accountOwner")).openAccount(acctResultSet.getString("accountType"));
                Account.accountsList.get(Account.accountsList.size() - 1).setBalance(acctResultSet.getDouble("accountBalance"));
            }
            DBController.close();
        }catch(Exception e){
            System.out.println(e);
        }

        /**
         * Populate the label fields with some initial values
         */
        custNumLabel.setText("Customer Number: " + Integer.toString(Customer.customersList.get(1).getCustomerNumber()));
        custNameLabel.setText("Name: " + Customer.customersList.get(1).getFirstName() + " " + Customer.customersList.get(1).getLastName());
        custAddressLabel.setText("Address: " + Customer.customersList.get(1).getAddress());
        custDOBLabel.setText(Customer.customersList.get(1).getDateOfBirth());
        customerImageView.setImage(Customer.customersList.get(1).getCustomerImage());

        /**
         * Set current customer and accounts to 1 each, and call the update functions
         */
        currentCust = 1;
        currentAccount = 1;
        updateAccounts();
        updateCustomer();
    }
}