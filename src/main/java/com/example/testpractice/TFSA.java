package com.example.testpractice;

public class TFSA extends Account{
    private static double interestRate = 0.05;
    private double contributionLimit;

    public String getAccountType() {
        return accountType;
    }

    private static String accountType = "TFSA";

    public TFSA(int customerNumber) {
        super(customerNumber);
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        TFSA.interestRate = interestRate;
    }

    public double getContributionLimit() {
        return contributionLimit;
    }

    public void setContributionLimit(double contributionLimit) {
        this.contributionLimit = contributionLimit;
    }
}
