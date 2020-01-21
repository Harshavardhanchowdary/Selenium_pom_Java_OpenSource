package helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {

    private static boolean root =false;

    public static Logger getLogger(Class cls){

        //Check if there is any active root logger
        if(root){
            //return root logger
            return Logger.getLogger(cls);
        }
        //Create a new root logger
        PropertyConfigurator.configure("src/resources/configfile/log4j.properties");
        root =true;
        return Logger.getLogger(cls);

    }

    /*unit test logger*/
    public static void main(String[] args) {


        Logger log = LoggerHelper.getLogger(LoggerHelper.class);
        log.info("This is message");
    }

}
