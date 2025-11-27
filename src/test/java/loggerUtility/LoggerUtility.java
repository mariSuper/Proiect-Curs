package loggerUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtility {

    private final Logger logger = LogManager.getLogger();

    //Metoda care indica inceperea Testului
    public void startTest(String testName){
        logger.info("****** EXECUTION STARTED "+ testName +" ******");
    }

    //Metoda care logheaza un info
    public void infoLog(String message){
        logger.info(message);
    }

    //Metoda care logheaza un error
    public void errorLog(String message){
        logger.error(message);
    }
    //Metoda care indica sfarsitul Testului
    public void finishtTest(String testName){
        logger.info("****** EXECUTION FINISHED "+ testName +" ******");
    }
}
