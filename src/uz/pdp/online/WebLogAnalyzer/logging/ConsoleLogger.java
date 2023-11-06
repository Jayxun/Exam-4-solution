package uz.pdp.online.WebLogAnalyzer.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class ConsoleLogger {
    private static Logger logger;

    public static void writeLog(String logName, Level level, String message){
        logger=Logger.getLogger(logName);
        logger.log(level,message);
    }


}
