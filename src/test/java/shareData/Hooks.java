package shareData;

import loggerUtility.LoggerUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends  ShareData{

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    public LoggerUtility loggerUtility = new LoggerUtility();

    @BeforeMethod
    public void prepareEnvironment(){
        setupEnvironment();
        loggerUtility.startTest("AlertTest");
    }

    @AfterMethod
    public void clearEnvironment(){
        quitDriver();
        loggerUtility.finishtTest("AlertTest");
    }
}
