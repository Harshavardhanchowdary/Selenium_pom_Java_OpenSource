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
                log.info("Verifying string are equal by ignoring case: '"
                        + actualString + "' with '"
                        +expectedString +"'");

                assertThat(actualString,equalToIgnoringCase(expectedString));
            }else if(ignore_whitespace){
                log.info("Verifying string are equal by whitespace: '"
                        + actualString + "' with '"
                        +expectedString +"'");
                assertThat(actualString,equalToCompressingWhiteSpace(expectedString));

            }else{
                log.info("Verifying string are equal : '"
                        + actualString + "' with '"
                        +expectedString +"'");
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
                log.info("Verifying string are not equal by ignoring case: '"
                        + actualString + "' with '"
                        +expectedString +"'");

                assertThat(actualString, not(equalToIgnoringCase(expectedString)));
            }else if(ignore_whitespace){
                log.info("Verifying string are not equal by whitespace: '"
                        + actualString + "' with '"
                        +expectedString +"'");
                assertThat(actualString, not(equalToCompressingWhiteSpace(expectedString)));

            }else{
                log.info("Verifying string are not equal : '"
                        + actualString + "' with '"
                        +expectedString +"'");
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
     *
     */
    public static void assertContainsString(String actualString, String expectedString){

        try{

            log.info("Verifying string: '"
                    + actualString + "' contains '"
                    +expectedString +"'");

            assertThat(actualString, containsString(expectedString));

        }catch (AssertionError e){
            log.error("String does not contain a given sub-string."
                    + e.getCause());

        }
    }


    /**
     * Verify that a string contains a given sub-string.
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     * @param message  - error message to be displayed
      */
    public static void assertContainsString(String actualString, String expectedString, String message){

        try{
            log.info("Verifying string: '"
                    + actualString + "' contains '"
                    +expectedString +"'");
            assertThat(actualString, containsString(expectedString));

        }catch (AssertionError e){
            log.error(message);
            log.error("String does not contain a given sub-string."
                    + e.getCause());

        }
    }


    /**
     * Verify that a string ends with a given string..
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     * @param message - Error message to be displayed
     */
    public static void assertEndsWith(String actualString, String expectedString, String message){

        try{
            log.info("Verifying string: '"
                    + actualString + "' ends with '"
                    +expectedString +"'");
            assertThat(actualString, endsWith(expectedString));

        }catch (AssertionError e){
            log.error(message);
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
    public static void assertEndsWith(String actualString, String expectedString){

        try{
            log.info("Verifying string: '"
                    + actualString + "' ends with '"
                    +expectedString +"'");
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
     * @param message - Error message to be displayed
     */
    public static void assertStartsWith(String actualString, String expectedString, String message){

        try{
            log.info("Verifying string: '"
                    + actualString + "' starts with '"
                    +expectedString +"'");
            assertThat(actualString, startsWith(expectedString));

        }catch (AssertionError e){
            log.error(message);
            log.error("String: '"+actualString
                    + "' does not start with given string: '"
                    + expectedString+"'"+ e.getCause());

        }
    }

    /**
     * Verify that a string ends with a given string..
     *
     * @param actualString - The value to be compared against.
     * @param expectedString - The expected value.
     */
    public static void assertStartsWith(String actualString, String expectedString){

        try{
            log.info("Verifying string: '"
                    + actualString + "' starts with '"
                    +expectedString +"'");
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
     * @param message - Error message to be displayed
     */
    public static void assertMatchRegularExpression(String actualString, String rePattern, String message){

        try{
            log.info("Verifying string: '"
                    + actualString + "' mathes with '"
                    +rePattern +"' regex pattern");

            assertThat(actualString, matchesRegex(rePattern));

        }catch (AssertionError e){
            log.error(message);
            log.error("String: '"+actualString
                    + "' does not match with regular expression: '"
                    + rePattern+"'"+ e.getCause());

        }
    }





    /**
     * Verifies that a string matches a regular expression.
     *
     * @param actualString - The value to be compared against.
     * @param rePattern - The regular expression to search for.
     */
    public static void assertMatchRegularExpression(String actualString, String rePattern){

        try{
            log.info("Verifying string: '"
                    + actualString + "' mathes with '"
                    +rePattern +"' pattern");

            assertThat(actualString, matchesRegex(rePattern));

        }catch (AssertionError e){
            log.error("String: '"+actualString
                    + "' does not match with regular expression: '"
                    + rePattern+"'"+ e.getCause());

        }
    }


    /**
     * Make Test pass
     */
    public static void makeTrue(){
        log.info("Making test pass...");
        Assert.assertTrue(true);
    }

    /**
     * Make test pass with message
     * @param message
     */

    public static void makeTrue(String message){
        log.info("Making test pass, with message :" + message);

        Assert.assertTrue(true, message);
    }


    /**
     * Make test fail
     */
    public static void makeFalse(){
        log.info("Making test fail...");

        Assert.assertTrue(true);
    }

    /**
     * Make test fail with message
     * @param message
     */
    public static void makeFalse(String message){
        log.info("Making test fail, with message :" + message);
        Assert.assertTrue(true, message);
    }

    /**
     * Verify that the object is null
     * @param s1
     */
    public static void verifyNull(String s1){
        log.info("Verify object is null");
        Assert.assertNull(s1);
    }


    /**
     * Verify that the object is not null
     * @param s1
     */
    public static void verifyNotNull(String s1){
        log.info("Verify object is not null");
        Assert.assertNotNull(s1);
    }


    /**
     * Verify that the status is true
     * @param status
     */
    public static void verifyTrue(boolean status){

        Assert.assertTrue(status);
    }

    /**
     * Verify that the status is false
     * @param status
     */
    public static void verifyFalse(boolean status){
        Assert.assertFalse(status);
    }



}
