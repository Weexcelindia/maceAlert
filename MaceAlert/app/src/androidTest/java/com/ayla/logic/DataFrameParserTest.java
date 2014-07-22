package com.ayla.logic;

import junit.framework.TestCase;

/**
 * Created by A on 6/27/14.
 */


public class DataFrameParserTest extends TestCase {

    DataFrameParser parserInstance;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        parserInstance=DataFrameParser.getInstance();
    }

    public void testInstanceNotNull()
    {
        assertNotNull(parserInstance);
    }

    public void testHexaDecimalString()
    {
        String expectedHex="85e95d7e176c8638727ddb22a1f8ec76c768b1d7df";
        String inputBasestring="heldfhdshjhyfdsiofjsdsdosdff";

        String hexString=parserInstance.tohexadecimalString(inputBasestring);
        assertEquals(expectedHex,hexString);
    }

    public void testdecodehexadecimalString()
    {
        String expectedBase="aGVsbG8gd29ybGRob3cgYXJlIHlvdQ==";
        String inputHexstring="68656c6c6f20776f726c64686f772061726520796f75";

        String result=parserInstance.decodehexadecimalString(inputHexstring);
        assertEquals(expectedBase,result.trim());
    }

    public void testBase64()
    {
        String expected="aGVsbG8gd29ybGRob3cgYXJlIHlvdQ==";
        String inputString="hello worldhow are you";

        String result=parserInstance.base64(inputString);
        assertEquals(expected,result.trim());
    }

    public void testIsBit()
    {
        boolean result=parserInstance.isBit(10,5);
        assertTrue(!result);
    }

    public void testupfillHexInt()
    {
        String expected="1005x";
        String result=parserInstance.upfillHexInt(10,5);
        assertEquals(expected,result);
    }

    public void testupfillHex()
    {
        String expected="1005x";
        String result=parserInstance.upfillHex(10,5);
        assertEquals(expected,result);
    }

    public void testfillNameToHex()
    {
        String expected="53656E6F773231000000000000000000";
        String input="Sensor1";
        int length=32;
        String result=parserInstance.fillNameToHex(input,length);
        assertEquals(expected,result);
    }
}
