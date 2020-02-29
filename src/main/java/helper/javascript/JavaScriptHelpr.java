package helper.javascript;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelpr {

    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(JavaScriptHelpr.class);


    public JavaScriptHelpr(WebDriver driver){
        this.driver = driver;
        log.info("JavaScriptHelper has been initialised");
    }


    /**
     * This method is used to execute the javaScript
     * @param script
     * @return
     */
    public Object executeJavaScript(String script){
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);

    }

    /**
     * This method is used to execute the javaScript using arguments
     * @param script
     * @param args
     * @return
     */
    public Object executeJavaScript(String script, Object...args){
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);

    }


    /**
     * This method is used to scroll to element using JavascriptExecutor
     * @param element
     */
    public void scrollToElement(WebElement element){
        log.info("Scrolling to element: " + element.toString());
        executeJavaScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);

    }


    /**
     * This method is used to scroll to element and click using JavascriptExecutor
     * @param element
     */
    public void scrollToElementAndClick(WebElement element){
        log.info("Scrolling to element: " + element.toString());
        scrollToElement(element);
        log.info("Clicking on element: " + element.toString());
        element.click();
        log.info("Clicked on element: " + element.toString());

    }


    /**
     * This method is used to Scroll into view using JavascriptExecutor
     * @param element
     */
    public void scrollIntoView(WebElement element){
        log.info("Scrolling element into view: " + element.toString());
        executeJavaScript("arguments[0].scrollIntoView()",element);
        log.info("Scrolled element into view " + element.toString());

    }

    /**
     * This method is used to Scroll into view and Click on element using JavascriptExecutor
     * @param element
     */
    public void scrollIntoViewAndClick(WebElement element){
        log.info("Scrolling element into view: " + element.toString());
        scrollIntoView(element);
        log.info("Scrolled element into view " + element.toString());
        element.click();
        log.info("Clicked on element: " + element.toString());

    }

    /**
     * This method is used to Click on element using JavascriptExecutor
     * @param element
     */
    public void JSClick(WebElement element){
        log.info("Trying to click on element: " + element.toString());
        executeJavaScript("arguments[0].click()",element);
        log.info("Clicked on element: " + element.toString());

    }


    /**
     * This method is ued to scroll down vertically by page height
     */
    public void scrollDownVerticaly(){
        log.info("Scrolling down vertically.");
        executeJavaScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    /**
     * This method is ued to scroll up vertically by page height
     */
    public void scrollUpVertically(){
        log.info("Scrolling up vertically.");
        executeJavaScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    /**
     * This method is ued to scroll down vertically by pixels provided
     * @param pixel
     */
    public void scrollDownByPixel(int pixel){
        log.info("Scrolling down vertically by :" + pixel + "pixels.");
        executeJavaScript("window.scrollTo(0,"+pixel+")");
    }

    /**
     * This method is ued to scroll up vertically by pixels provided
     * @param pixel
     */
    public void scrollUpByPixel(int pixel){
        log.info("Scrolling up vertically by :" + pixel + "pixels.");
        executeJavaScript("window.scrollTo(0,-"+pixel+")");
    }


    /**
     * This method is ued to zoom page by given percent
     * @param zoomPercent
     */
    public void zoomInBy(int zoomPercent){
        log.info("Setting page zoom to: " + zoomPercent + "%.");
        executeJavaScript("document.body.style.zoom='"+zoomPercent+"'");
        log.info("Page zoom set to: " + zoomPercent + "%.");
    }






}

