package com.example.testpractice;

import javafx.scene.image.Image;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account, account2;

    @Before
    public void setUp() throws Exception {
        account = new Account("Chequing");
        account.setBalance(100.55);

        account2 = new Account("Chequing");
        account2.setBalance(200);

        Account.accountsList.add(account);
        account.setAccountNumber(Account.accountsList.size() - 1);

        Account.accountsList.add(account2);
        account2.setAccountNumber(Account.accountsList.size() - 1);
    }

    @Test
    public void setBalance() {
        account.setBalance(100.55);
        assertEquals(100.55, account.getBalance(), .0001);
    }

    @Test
    public void setBalanceInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.setBalance(-10);});
    }

    @Test
    public void getBalance() {
        assertEquals(100.55, account.getBalance(), .0001);
    }

    @Test
    public void setAccountNumberInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.setAccountNumber(-1);});
    }

    @Test
    public void setAccountNumber() {
        account.setAccountNumber(9);
        assertEquals(9, account.getAccountNumber());
    }

    @Test
    public void getAccountNumber() {
        assertEquals(0, account.getAccountNumber());
    }

    @Test
    public void deposit() {
        double balanceStart = account.getBalance();
        account.deposit(10.55);
        assertEquals((balanceStart + 10.55), account.getBalance(), 0.0001);
    }

    @Test
    public void depositInvalid() {
        //Try depositing zero, try depositing a negative amount
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.deposit(0);});
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.deposit(-10);});
    }

    @Test
    public void withdraw() {
        double balanceStart = account.getBalance();
        account.withdraw(10.55);
        assertEquals((balanceStart - 10.55), account.getBalance(), 0.0001);
    }

    @Test
    public void withdrawInvalid() {
        //Try withdrawing zero, try withdrawing an arbitrarily large amount
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.withdraw(0);});
        Assertions.assertThrows(IllegalArgumentException.class, () ->{account.withdraw(1000000000);});
    }

    @Test
    public void fundsTransfer() {

        double balanceStart1 = account.getBalance();
        double balanceStart2 = account2.getBalance();

        double amount = 100;

        Account.fundsTransfer(amount, account.getAccountNumber(), account2.getAccountNumber());

        assertEquals((balanceStart1 - amount), account.getBalance(), .0001);
        assertEquals((balanceStart2 + amount), account2.getBalance(), .0001);
    }

    @Test
    public void fundsTransferInvalid() {
        //Transfer more than is in the sender's account
        Assertions.assertThrows(IllegalArgumentException.class, () ->{Account.fundsTransfer(400, 1, 0);});

        //Transfer a negative amount, transfer zero
        Assertions.assertThrows(IllegalArgumentException.class, () ->{Account.fundsTransfer(-10, 1, 0);});
        Assertions.assertThrows(IllegalArgumentException.class, () ->{Account.fundsTransfer(0, 1, 0);});
    }


}