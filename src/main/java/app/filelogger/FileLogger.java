package app.filelogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import app.Logger;
import app.LoggingLevel;

public class FileLogger implements Logger {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final SimpleDateFormat formatterName = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
    private final FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
    private String fileName;

    public FileLogger() {
        createNewLogFile();
    }

    @Override
    public void debug(String message) {
        logMessage(LoggingLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        logMessage(LoggingLevel.INFO, message);
    }

    private void logMessage(LoggingLevel level, String message) {
        Date currentDate = new Date();
        File file = new File(fileName);

        if (level.ordinal() <= config.getLoggingLevel().ordinal()) {
            if (file.length() > config.getSizeLimit()) {
                createNewLogFile();
                file = new File(fileName);
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.printf(config.getFormat(), formatter.format(currentDate), level, message);
            } catch (IOException e) {
                System.out.println("Ошибка записи в лог: " + e.getMessage());
            }
        }
    }

    private void createNewLogFile() {
        int fileIndex = 1;
        String baseFileName = config.getLoggerPath() + formatterName.format(new Date()) + "_logger";
        String newFileName = baseFileName + ".log";

        File newFile = new File(newFileName);

        while (newFile.exists()) {
            newFileName = baseFileName + "(" + fileIndex++ + ").log";
            newFile = new File(newFileName);
        }

        this.fileName = newFileName;
        System.out.println("Создан новый лог-файл: " + newFileName);
    }
}
