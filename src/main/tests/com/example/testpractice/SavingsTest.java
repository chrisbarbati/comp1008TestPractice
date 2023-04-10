package com.example.testpractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsTest {

    private Savings savings;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void setInterestRate() {
        savings = new Savings();
        savings.setInterestRate(0.05);
        assertEquals(0.05, savings.getInterestRate(), .00001);
    }
}