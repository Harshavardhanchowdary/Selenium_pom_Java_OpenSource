package helper.listener;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private Logger log = LoggerHelper.getLogger(Retry.class);

    private int retryCount = 0;
    private int MAX_RETRY_COUNT = 3;

    @Override
    public boolean retry(ITestResult args0) {

        if(retryCount<MAX_RETRY_COUNT){
            log.info("--------------------------------------------------------------------------------------------");
            log.info("Retrying test -> "+ args0.getName()+ " <- with status "+ getResultStatusName(args0.getStatus()) +" for the "+ (retryCount+1)+" time");
            log.info("--------------------------------------------------------------------------------------------");
            retryCount++;
            return true;
        }
        return false;
    }


    public String getResultStatusName(int status){
        String resultName = null;
        switch(status){

            case 1:
                resultName = "SUCCESS";
                break;

            case 2:
                resultName = "FAILURE";
                break;

            case 3:
                resultName = "SKIP";
                break;

            default:
                resultName = "STATUS UNKNOWN";
        }

        return resultName;


    }



}
