
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileLogger implements Logger {
    private final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat formaterName = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
    private final Date date = new Date();
    FileLoggerConfiguration config = new FileLoggerConfiguration();
    private final String fileName = config.getLoggerPath() + formaterName.format(date) + " logger.txt";
    File file = new File(fileName);
    long fileSize = file.length();

    @Override
    public void debug(String message)  {
        if (config.getLoggingLevel() == LoggingLevel.DEBUG) {
            if (fileSize <= config.getSizeLimit()) {
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));

                    writer.printf(config.getFormat(), formater.format(date), config.getLoggingLevel(), message);
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.printf(config.getFormat(), formater.format(date), config.getLoggingLevel(), message);
        }
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException {
        if (fileSize <= config.getSizeLimit()) {
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));
                writer.printf(config.getFormat(), formater.format(date), "INFO", message);
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else {
            throw new FileMaxSizeReachedException("Допустимый размер файла " + config.getSizeLimit() + ", текущий размер файла " + fileSize + " Путь к файлу " + fileName );
        }
            System.out.printf("[%s][INFO] message: %s %n", formater.format(date), message);
        }
    }





