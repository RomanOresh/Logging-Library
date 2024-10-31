import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfiguration {
    private final  String loggerPath = "files/";
    private final  LoggingLevel loggingLevel = LoggingLevel.DEBUG;
    private final  long sizeLimit = 1000;
    private final  String format = "[%s][%s] message: %s %n";

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
