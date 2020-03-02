package helper.assertion;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {

    private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
    private WebDriver driver;


    public VerificationHelper(WebDriver driver){
        this.driver = driver;
    }


    public boolean isDisplayed(WebElement element){

        try{
            element.isDisplayed();
            log.info("The Element is displayed: "+ element.toString());
            return true;
        }catch (Exception e){
            log.error("Element is not displayed \n Exception: "+ e.getCause());
            return false;
        }
    }


    public boolean isNotDisplayed(WebElement element){

        try{
            element.isDisplayed();
            log.info("The Element is displayed: "+ element.toString());
            return false;
        }catch (Exception e){
            log.error("Element is not displayed \n Exception: "+ e.getCause());
            return true;
        }
    }


    public String getText(WebElement element){

        if(element == null){
            log.info("WebElement is null.");
            return null;
        }

        if(isDisplayed(element)){

            String textOfAnElement = element.getText();
            if(textOfAnElement !=null){

            log.info("Obtained the text of an element: "+ element.getText());
            return textOfAnElement;}
                else {
                    log.error("Not able to red the text");
                    return null;
                }
        }else{
            return null;
        }

    }



    // isselected, isEnabled,

}
