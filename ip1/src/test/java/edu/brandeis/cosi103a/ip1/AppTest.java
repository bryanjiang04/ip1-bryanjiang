package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddition() {
        int result = 2 + 3;
        assertEquals("Addition test failed", 5, result);
    }

    @Test
    public void testStringEquality() {
        String expected = "hello";
        String actual = "hello";
        assertEquals("String equality test failed", expected, actual);
    }

    @Test
    public void testBooleanCondition() {
        boolean condition = 5 > 3;
        assertTrue("Boolean condition test failed", condition);
    }

    @Test
    public void testFalseCondition() {
        boolean condition = 3 > 5;
        assertFalse("False condition test failed", condition);
    }

    @Test
    public void testNullValue() {
        String value = null;
        assertNull("Null test failed", value);
    }

    @Test
    public void testNotNull() {
        String value = "test";
        assertNotNull("Not null test failed", value);
    }

    @Test
    public void testSubtraction() {
        int result = 10 - 4;
        assertEquals("Subtraction test failed", 6, result);
    }

    @Test
    public void testMultiplication() {
        int result = 3 * 4;
        assertEquals("Multiplication test failed", 12, result);
    }

    @Test
    public void testDivision() {
        int result = 20 / 5;
        assertEquals("Division test failed", 4, result);
    }

    @Test
    public void testNegativeNumber() {
        int value = -5;
        assertTrue("Negative number test failed", value < 0);
    }

    @Test
    public void testEmptyString() {
        String value = "";
        assertEquals("Empty string test failed", "", value);
    }

    @Test
    public void testStringLength() {
        String value = "hello";
        assertEquals("String length test failed", 5, value.length());
    }
}
