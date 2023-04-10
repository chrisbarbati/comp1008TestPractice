package com.example.testpractice;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

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
    private TextField eftAmount;

    @FXML
    private Button eftConfirmation;

    @FXML
    private TextField eftRecipientNum;

    @FXML
    private TextField eftSenderNum;

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
     * Instantiates a new customer based on user input, and then adds it to the list of customers
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
            String accountInformation = "Account Number: " + account.getAccountNumber() + " Type: " + account.getAccountType() + " Balance: $" + account.getBalance();
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
     * EFT function - accesses the EFT function in the Account class
     */
    private void electronicFundsTransfer(){
        try{
            Account.fundsTransfer(Double.parseDouble(eftAmount.getText()),
                    Integer.parseInt(eftSenderNum.getText()),
                    Integer.parseInt(eftRecipientNum.getText()));
            System.out.println("EFT Confirmed");
            updateAccounts();
        }catch(Exception s){
            String message;
            if(s.toString().equals("java.lang.NumberFormatException: empty String") || s.toString().equals("java.lang.NumberFormatException: For input string: \"\"")){
                message = "Fields cannot be empty";
            }else if(s.toString().equals("java.lang.IllegalArgumentException: Sender and Receiver accounts cannot be the same")){
                message = s.toString();
                message = message.substring(36);
            }else {
                message = "Error, please retry";
            }
            errorOutput.setText(message);
            errorOutput.setTextFill(Color.RED);
        }
    }

    /**
     * Deposit function - accesses the deposit function in the account class
     */
    private void deposit() {
        try {
            Account.accountsList.get(currentAccount).deposit(Double.parseDouble(depositAmt.getText()));
            System.out.println("Deposit");
            updateAccounts();
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
        eftConfirmation.setOnMouseClicked(event -> electronicFundsTransfer());
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
        Customer.customersList.get(0).openAccount("Chequing");

        //Create a new customer object "Christian", and store in customer list
        Customer.customersList.add(new Customer("portrait1.jpg", Customer.customersList.size(), 1525, "Christian", "Barbati",
                "742 Evergreen Terrace", "06-22-1998"));

        //Create a new customer object "Jenny" and store in customer list
        Customer.customersList.add(new Customer("portrait2.jpg", Customer.customersList.size(),9486, "Jenny", "Baker",
                "247 Evergreen Terrace", "12-12-1998"));

        //Create a new customer object "Michael" and store in customer list
        Customer.customersList.add(new Customer("portrait3.jpg", Customer.customersList.size(),3854, "Michael", "Smith",
                "471 Evergreen Terrace", "07-15-1998"));

        /**
         * Open some accounts for our customers. Added in random order to demonstrate that forward and back buttons
         * function agnostic of list position
         */
        Customer.customersList.get(1).openAccount("Chequing");
        Customer.customersList.get(1).openAccount("Savings");
        Customer.customersList.get(2).openAccount("Savings");
        Customer.customersList.get(2).openAccount("TFSA");
        Customer.customersList.get(3).openAccount("Savings");
        Customer.customersList.get(2).openAccount("Chequing");
        Customer.customersList.get(2).openAccount("Savings");
        Customer.customersList.get(1).openAccount("Chequing");
        Customer.customersList.get(3).openAccount("Savings");


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