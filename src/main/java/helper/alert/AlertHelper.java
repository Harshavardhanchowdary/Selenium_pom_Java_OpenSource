package helper.alert;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

/**
 * This class can be used to get the text from the popup
 * and accept or dismiss alerts.
 */
public class AlertHelper {

   private Logger log = LoggerHelper.getLogger(AlertHelper.class);
    private WebDriver driver;



    public AlertHelper(WebDriver driver){
        this.driver=driver;
        log.info("AlertHelper object is created ..");
    }


    /**
     * This method is ued to get the alert
     * @return alert
     */
    public Alert getAlert(){
        log.info("Alert test: "+ driver.switchTo().alert().getText());
        return driver.switchTo().alert();

    }


    /**
     *This method is used to accept alert
     */
    public void acceptAlert(){
        log.info("Accepting alert: "+getAlert().getText());
        getAlert().accept();
        log.info("Alert: "+getAlert().getText() + "accepted.");


    }


    /**
     *This method is used to dismiss alert
     */
    public void dismissAlert(){
        log.info("Dismissing alert: "+getAlert().getText());
        getAlert().dismiss();
        log.info("Alert: "+getAlert().getText() + "dismissed.");


    }


    /**
     *This method is used get the text displayed on the alert
     */
    public String getAlertText(){
        log.info("Getting alert text ");
        String alertText = getAlert().getText();
        log.info("Alert text:"+getAlert().getText());
        return alertText;

    }


    /**
     *
     *To check if the alert is peresnt
     * @return boolean
     */
    public boolean isAlertPresent(){
        log.info("Checking if the alert is present ");
        try{
            getAlert().accept();
            log.info("Alert text:"+getAlert().getText());
            return true;}
        catch (NoAlertPresentException e){
            log.info("Alert is not present"+ e.getCause());
            return false;
        }
    }


    /**
     * Accept the alert if the alert is present
     */
    public void acceptAlertIfIsPresent(){
        if(isAlertPresent()){
            log.info("Alert is present ");
            getAlert().accept();
            log.info("Alert: "+getAlert().getText() + "accepted.");

        }else{
            log.info("Alert is not present ");
        }
    }


    /**
     * Dismiss the alert if the alert is present
     */
    public void dismissAlertIfIsPresent(){
        if(isAlertPresent()){
            log.info("Alert is present ");
            getAlert().dismiss();
            log.info("Alert: "+getAlert().getText() + "dismissed.");
        }{
            log.info("Alert is not present ");
        }
    }


    /**
     * Enter the text and accept the prompt
     * @param text
     */
    public void acceptPrompt(String text){
        if(isAlertPresent()){
            log.info("Alert is present ");
            getAlert().sendKeys(text);
            getAlert().accept();
            log.info("Alert: "+getAlert().getText() + "accepted.");
        }else{
            log.info("Alert is not present ");
        }
    }




}
