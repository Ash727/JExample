package com.teamtreehouse.vending;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.*;

public class AlphaNumericChooserTest {

    private AlphaNumericChooser chooser;

    @Rule // doenst have to be name thrown can be anything
    public ExpectedException thrown = ExpectedException.none();

    // ALways ran before any test
    @Before
    public void setUp() throws Exception {
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        //Assembly then act
        AlphaNumericChooser.Location  loc = chooser.locationFromInput("B4");
        // Assert
        assertEquals("proper row",1,loc.getRow());
        assertEquals("propercolumn",3,loc.getColumn());

        //
    }

    @Test(expected= InvalidLocationException.class)
    public void ChoosingInputIsNotAllowed() throws Exception {
        chooser.locationFromInput("WRONG");
    }

    @Test(expected =InvalidLocationException.class)
    public void choosingLargerTHanMaxIsNotAllowed () throws Exception {
        chooser.locationFromInput("B52");
    }

    @Test
    public void constructingLargerTHanALphabetNotALlowed () throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Maximum rows supported is 26");
        new AlphaNumericChooser(27,10);

    }


}