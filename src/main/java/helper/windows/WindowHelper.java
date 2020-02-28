package helper.windows;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHelper {

    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(WindowHelper.class);


    public WindowHelper(WebDriver driver){
        this.driver = driver;
    }

    /*************************************************************************
     *
     *                          WINDOW NAVIGATION
     *
     *************************************************************************/


    /**
     * This method will switch control to parent window
     */
    public void switchToParentWindow(){
        log.info("Switching to parent window");
        driver.switchTo().defaultContent();

    }

    /**
     * This method will switch the window by index
     *
     * @param index
     */
    public void switchToWindowByIndex(int index){
        log.info("Switching to window by index: " + index);
        Set<String> windows = driver.getWindowHandles();
        int i = 1;
        for(String window: windows){
            if(i == index){
                driver.switchTo().window(window);
                log.info("Switched to window '" + window +"' at index: " + index);
            }else{
                i++;
            }
        }

    }


    /**
     * This method will close all the child windows and navigate back to parent window
     */
    public void closeAllWindowsAndSwitchToParentWindow(){
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        log.info("Closing all the child windows");

        for (String window: windows){
            if(!window.equalsIgnoreCase(parentWindow)){
                driver.close();
            }
        }
        log.info("Closed all child windows and switching back to parent window");

        driver.switchTo().window(parentWindow);

        log.info("Switched to parent window");
    }


    /*************************************************************************
     *
     *                          PAGE NAVIGATION
     *
     *************************************************************************/


    /**
     * This method is used to navigate to next web page
     */

    public void navigateForward(){
        log.info("Navigating to next page");

        driver.navigate().forward();
    }


    /**
     * This method is used to navigate to beck to previous web page
     *
     */
    public void navigateBack(){
        log.info("Navigating pack to previous page");
        driver.navigate().back();
    }




}
