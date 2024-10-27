import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger implements Logger{
    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Date date = new Date();
    private LoggingLevel loggingLevel = LoggingLevel.INFO;

    public void setLoggingLevel(LoggingLevel loggingLevel){
        switch (loggingLevel){
            case INFO -> {
                LoggingLevel yourLogginLevel = LoggingLevel.INFO;
                this.loggingLevel = yourLogginLevel;
                System.out.println("Your access level is INFO" );
                break;
            }
            case DEBUG -> {
                LoggingLevel yourLogginLevel = LoggingLevel.DEBUG;
                this.loggingLevel = yourLogginLevel;
                System.out.println("Your access level is DEBUG");
                break;
            }
        }
    }

    @Override
    public void debug(String message) throws Exception {
//        System.out.println("[" + formater.format(date) + "][DEBUG] message:" + " " + message);
        if (loggingLevel == LoggingLevel.DEBUG) {
            System.out.printf("[%s][DEBUG] message: %s %n", formater.format(date), message);
        }
    }

    @Override
    public void info(String message) throws Exception {
//        System.out.println("[" + formater.format(date) + "][INFO] message:" + " " + message);
        System.out.printf("[%s][INFO] message: %s %n" ,formater.format(date), message);
    }


}
