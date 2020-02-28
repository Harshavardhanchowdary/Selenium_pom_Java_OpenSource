package helper.wait;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class WaitHelper {

    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(WaitHelper.class);


    public WaitHelper(WebDriver driver){
        this.driver = driver;
    }


    /**
     * This function is used to set implicit wait
     *
     * -->Directs the Selenium WebDriver to wait for a certain measure of time before throwing an exception.
     * Once this time is set, WebDriver will wait for the element before the exception occurs.
     *
     * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     * @param timeout -- Time out value
     * @param unit -- unit of time out
     */
    public void setImplicitWait(long timeout, TimeUnit unit){
        log.info("Implicit Wait has been set to: "+ timeout +", "+unit);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }


    private WebDriverWait getWait(long timeOutInSeconds, int pollingEveryMilliSeconds ){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.pollingEvery(Duration.ofMillis(pollingEveryMilliSeconds));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(NoSuchFrameException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait;

    }

    /**
     * This method will wait until the given element is visible
     *
     * @param element -- Web element to be visible
     * @param timeOutInSeconds  -- Time out in seconds
     * @param pollingEveryMilliSeconds -- Polling interval
     */
    public void waitForElementVisible(WebElement element, long timeOutInSeconds, int pollingEveryMilliSeconds){

        log.info("Waiting for " + element.toString() + "to be visible for " + timeOutInSeconds +"seconds");
        WebDriverWait wait = getWait(timeOutInSeconds,pollingEveryMilliSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now.");

    }


    /**
     * This method will wait until the element is visible and enabled such that you can click it.
     *
     * @param element -- Web element to be clickable
     * @param timeOutInSeconds -- Time out in seconds
     */
    public void waitForElementToBeClickable(WebElement element, long timeOutInSeconds){

        log.info("Waiting for " + element.toString() + "to be Clickable for " + timeOutInSeconds +"seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is 'Clickable' now.");


    }


    /**
     * This method will wait for element to be invisible
     *
     * @param element -- Web element to be invisible
     * @param timeOutInSeconds -- Time out in seconds
     */
    public void waitForElementNotPresent(WebElement element, long timeOutInSeconds){

        log.info("Waiting for " + element.toString() + "to be not present for " + timeOutInSeconds +"seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        if (wait.until(ExpectedConditions.invisibilityOf(element))) {
            log.info("Element is 'invisible ' now.");

        }else{

            log.error("Element is still visible");
        }

    }


    /**
     * This method will wait for frame to be available and Switch to it
     *
     * @param element -- Frame to be available and Switch to
     * @param timeOutInSeconds -- Time out in seconds
     */
    public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds){

        log.info("Waiting for " + element.toString() + "to be not Available for " + timeOutInSeconds +"seconds");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Frame is Available and Switch to it");

    }


    /**
     *
     * @param timeOutInSeconds
     * @param pollingEveryMilliSeconds
     * @return
     */
    public Wait<WebDriver> getFluentWait(long timeOutInSeconds, int pollingEveryMilliSeconds){
        Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingEveryMilliSeconds))
                .ignoring(NoSuchElementException.class);

        return fluentwait;

    }


    /**
     * This method will wait for an element to be visible
     *
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryMilliSeconds
     * @return
     */
    public WebElement waitForElement(WebElement element, long timeOutInSeconds, int pollingEveryMilliSeconds ){

        Wait<WebDriver> fluentWait = getFluentWait(timeOutInSeconds,pollingEveryMilliSeconds);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    /**
     * This method will wait for page to load
     *
     * @param timeOut
     * @param unit
     */
    public void waitForPageToLoad(long timeOut, TimeUnit unit){
        log.info("Waiting for page to load for "+ timeOut + " " + unit);
        driver.manage().timeouts().pageLoadTimeout(timeOut, unit);

    }



}
