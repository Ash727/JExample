package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;

    @Test
    public void addingFundsIncrementsAvailbleFunds () throws Exception {
      // Testing Triple As (AAA)
        // Arrange
        creditor = new Creditor();

      // Act
        creditor.addFunds(25);
        creditor.addFunds(25);
        // assert
        assertEquals(50,creditor.getAvailableFunds());

    }

    // occurs before every test
    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @Test
    public void refundingREturnsAllAvailbleFunds() throws Exception {
        // Arrange
//         creditor = new Creditor();


        // Act
        creditor.addFunds(10);
        int refund = creditor.refund();

        // Assert
        assertEquals(10,refund);
        assertEquals(0, creditor.getAvailableFunds());
    }
}