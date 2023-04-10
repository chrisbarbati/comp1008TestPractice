package com.example.testpractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChequingTest {

    private Chequing chequing;

    @Before
    public void setUp() throws Exception {
        chequing = new Chequing();
    }

    @Test
    public void setInterestRate() {
        chequing.setInterestRate(0.05);
        assertEquals(0.05, chequing.getInterestRate(), .00001);
    }

    @Test
    public void getInterestRate() {
        assertEquals(0.01, chequing.getInterestRate(), .00001);
    }

    @org.junit.Test
    public void setInterestRateInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {chequing.setInterestRate(2);});
    }
}