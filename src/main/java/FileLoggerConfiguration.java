public class FileLoggerConfiguration {




    private String loggerPath;
    private LoggingLevel loggingLevel;
    private long sizeLimit;
    private String format;

    public FileLoggerConfiguration(){
        this.loggerPath = "files/";
        this.loggingLevel = LoggingLevel.INFO;
        this.sizeLimit = 1000;
        this.format = "[%s][%s] message: %s %n";
    }
    public FileLoggerConfiguration(String loggerPath, LoggingLevel loggingLevel, long sizeLimit, String format){
        this.loggerPath = loggerPath;
        this.loggingLevel = loggingLevel;
        this.sizeLimit = sizeLimit;
        this.format = format;
    }

    public String getLoggerPath() {
        return loggerPath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getSizeLimit() {
        return sizeLimit;
    }

    public String getFormat() {
        return format;
    }
}
