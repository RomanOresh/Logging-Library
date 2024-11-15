package app.consolelogger;

import app.LoggingLevel;

public class ConsoleLoggerConfiguration {

    private String format;
    private LoggingLevel loggingLevel;

    public ConsoleLoggerConfiguration(){
        this.format = "[%s][%s] message: %s %n";
        this.loggingLevel = LoggingLevel.INFO;
    }

    public ConsoleLoggerConfiguration(String format, LoggingLevel loggingLevel){
        this.loggingLevel = loggingLevel;
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
}
