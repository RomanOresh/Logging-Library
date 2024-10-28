
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger implements Logger {
    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat formaterName = new SimpleDateFormat("yyyy-MM-dd");
    private final Date date = new Date();
    private LoggingLevel loggingLevel = LoggingLevel.INFO;
    private final String fileName = formaterName.format(date) + " logger.txt";

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        switch (loggingLevel) {
            case INFO -> {
                this.loggingLevel = LoggingLevel.INFO;
                System.out.println("Your access level is INFO");
                break;
            }
            case DEBUG -> {
                this.loggingLevel = LoggingLevel.DEBUG;
                System.out.println("Your access level is DEBUG");
                break;
            }
        }
    }

    @Override
    public void debug(String message) throws Exception {
        if (loggingLevel == LoggingLevel.DEBUG) {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(FileLoggerConfiguration.loggerPath + fileName,true));

                writer.printf(FileLoggerConfiguration.format, formater.format(date), loggingLevel, message);
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


            System.out.printf(FileLoggerConfiguration.format, formater.format(date), loggingLevel, message);
        }
    }

    @Override
    public void info(String message) throws Exception {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(FileLoggerConfiguration.loggerPath + fileName, true));

                writer.printf(FileLoggerConfiguration.format, formater.format(date), "INFO", message);
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.printf("[%s][INFO] message: %s %n", formater.format(date), message);


        }
    }





