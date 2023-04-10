package com.example.testpractice;

import static org.junit.Assert.*;

public class TFSATest {
    private TFSA tfsa;

    @org.junit.Before
    public void setUp() throws Exception {
        tfsa = new TFSA();
    }

    @org.junit.Test
    public void setInterestRate() {
        tfsa.setInterestRate(0.05);
        assertEquals(0.05, tfsa.getInterestRate(), .00001);
    }

    @org.junit.Test
    public void setInterestRateInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {tfsa.setInterestRate(2);});
    }

    @org.junit.Test
    public void getInterestRate() {
        assertEquals(0.05, tfsa.getInterestRate(), .00001);
    }
}