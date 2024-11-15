package app.consolelogger;

import app.Logger;
import app.LoggingLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements Logger {
    private final ConsoleLoggerConfiguration config = ConsoleLoggerConfigurationLoader.load();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void debug(String message) {
        logMessage(LoggingLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        logMessage(LoggingLevel.INFO, message);
    }

    private void logMessage(LoggingLevel level, String message) {
        if (level.ordinal() <= config.getLoggingLevel().ordinal()) {
            System.out.printf(config.getFormat(), formatter.format(new Date()), level, message);
        }
    }
}
