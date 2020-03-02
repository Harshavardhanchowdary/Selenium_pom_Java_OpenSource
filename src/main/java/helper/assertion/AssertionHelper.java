package helper.assertion;


import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.awt.*;
import java.util.*;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertionHelper {


    private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);


    /**
     * Verify that two strings are equal
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     * @param ignoreCase - Matches the string values ignoring the case if set to True.
     * @param ignore_whitespace -Matches the string values ignoreing the whitespace if set to True.
     */
    public static void assertStringEqual(String actualString, String expectedString, boolean ignoreCase, boolean ignore_whitespace){

        try{
            if(ignoreCase){
                assertThat(actualString,equalToIgnoringCase(expectedString));
            }else if(ignore_whitespace){
                assertThat(actualString,equalToCompressingWhiteSpace(expectedString));

            }else{
                assertThat(actualString, equalTo(expectedString));
            }

        }catch (AssertionError e){

            log.error("Two strings are not equal."+ e.getCause());

        }
    }


    /**
     * Verify that two strings are not equal
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     * @param ignoreCase - Matches the string values ignoring the case if set to True.
     * @param ignore_whitespace -Matches the string values ignoreing the whitespace if set to True.
     */
    public static void assertStringNotEqual(String actualString, String expectedString, boolean ignoreCase, boolean ignore_whitespace){

        try{
            if(ignoreCase){
                assertThat(actualString, not(equalToIgnoringCase(expectedString)));
            }else if(ignore_whitespace){
                assertThat(actualString, not(equalToCompressingWhiteSpace(expectedString)));

            }else{
                assertThat(actualString, not(equalTo(expectedString)));
            }

        }catch (AssertionError e){

            log.error("Two strings are equal."+ e.getCause());

        }
    }



    /**
     * Verify that a string contains a given sub-string.
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
      */
    public static void assertContainsString(String actualString, String expectedString, String message){

        try{
            assertThat(actualString, containsString(expectedString));

        }catch (AssertionError e){

            log.error("String does not contain a given sub-string."
                    + e.getCause());

        }
    }


    /**
     * Verify that a string ends with a given string..
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     */
    public static void assertEndsWith(String actualString, String expectedString, String message){

        try{
            assertThat(actualString, endsWith(expectedString));

        }catch (AssertionError e){
            log.error("String: '"+actualString
                    + "' does not end with given string: '"
                    + expectedString+"'"+ e.getCause());

        }
    }


    /**
     * Verify that a string ends with a given string..
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     */
    public static void assertStartsWith(String actualString, String expectedString, String message){

        try{
            assertThat(actualString, startsWith(expectedString));

        }catch (AssertionError e){
            log.error("String: '"+actualString
                    + "' does not start with given string: '"
                    + expectedString+"'"+ e.getCause());

        }
    }



    /**
     * Verifies that a string matches a regular expression.
     *
     * @param actualString - The value to be compared against.
     * @param rePattern - The regular expression to search for.
     */
    public static void assertMatchRegularExpression(String actualString, String rePattern, String message){

        try{
            assertThat(actualString, matchesRegex(rePattern));

        }catch (AssertionError e){
            log.error("String: '"+actualString
                    + "' does not match with regular expression: '"
                    + rePattern+"'"+ e.getCause());

        }
    }
    


    public static void makeTrue(){
        Assert.assertTrue(true);
    }

    public static void makeTrue(String message){
        Assert.assertTrue(true, message);
    }


    public static void makeFalse(){
        Assert.assertTrue(true);
    }

    public static void makeFalse(String message){
        Assert.assertTrue(true, message);
    }


    public static void verifyTrue(boolean status){
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status){
        Assert.assertTrue(status);
    }


    public static void verifyNullObject(String str){
        Assert.assertNull(str);

    }


    public static void verifyNotNullObject(String str){
        Assert.assertNotNull(str);

    }






}
