package app;

import app.consolelogger.ConsoleLogger;
import app.filelogger.FileLogger;

public class Main {

    private static FileLogger fileLogger = new FileLogger();
    private static ConsoleLogger consoleLogger = new ConsoleLogger();

    public static void main(String[] args){



        fileLogger.info("Started application");
        fileLogger.debug("Calling method X");
        fileLogger.info("Started application 1");
        fileLogger.debug("Calling method X 3");
        fileLogger.info("Started application 2");

        consoleLogger.info("dasdasda");
        consoleLogger.debug("123456");














    }
}
