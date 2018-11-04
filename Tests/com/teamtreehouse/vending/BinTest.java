package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;


    // rules allow you to redefined behaviour in each test method
    @Rule // doenst have to be name thrown can be anything
    public ExpectedException thrown = ExpectedException.none();


    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    // Expect illialgal arguemnet acception
    @Test(expected=IllegalArgumentException.class)
    public void restockingWithDifferntItemsIsNotAllowed () throws Exception {
        bin.restock("Cheetos",1,100,50);
        bin.restock("Doritos",1,100,50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0,bin.getItemPrice());
    }


    @Test
    public void whenEmptyNameisNull() throws Exception {
        assertNull(bin.getItemName()); //  Should assert to null note the differnt Assertion
    }

    @Test
    public void overStackingNotAllowed() throws Exception {
       thrown.expect(IllegalArgumentException.class);
       thrown.expectMessage("There are only 10 spots left");
        bin.restock("Fritos",2600,100,50);

    }


}