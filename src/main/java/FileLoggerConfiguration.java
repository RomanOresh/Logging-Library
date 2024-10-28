import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfiguration extends FileLogger {
    protected static String loggerPath = "files/";
    private LoggingLevel loggingLevel;
    private static long sizeLimit = 42;
    protected static String format = "[%s][%s] message: %s %n";


}
