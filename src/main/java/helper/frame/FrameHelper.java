package helper.frame;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(FrameHelper.class);


    public FrameHelper(WebDriver driver){
        this.driver = driver;
    }


    /**
     * This Method will switch to frame with based on index
     *
     * @param index
     */
    public void switchToFrameByIndex(int index){
        driver.switchTo().frame(index);
        log.info("Switched to frame with index: "+ index);
    }


    /**
     * This Method will switch to frame with based on framename
     *
     * @param frameName
     */
    public void switchToFrameByFrameName(String frameName){
        driver.switchTo().frame(frameName);
        log.info("Switched to frame with name: "+ frameName);
    }


    /**
     * This Method will switch to frame with based on webelemnt
     *
     * @param element
     */
    public void switchToFrameByWebElement(WebElement element){
        driver.switchTo().frame(element);
        log.info("Switched to frame with webelement "+ element.toString());
    }
}
