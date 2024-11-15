package app.filelogger;

import app.LoggingLevel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader  {

    private static final String CONFIG_PATH = "src/main/config/logger.config";

    public static FileLoggerConfiguration load() {
        Properties props = new Properties();
        try (FileInputStream fin = new FileInputStream(CONFIG_PATH)) {
        props.load(fin);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке файла конфигурации: " + e.getMessage());
            return new FileLoggerConfiguration();
        }
        String loggerPath = props.getProperty("FILEPATH");
        String loggingLevelSt = props.getProperty("LEVEL");
        long sizeLimit = Long.valueOf(props.getProperty("SIZELIMIT"));
        String format = props.getProperty("FORMAT");
        LoggingLevel loggingLevel = LoggingLevel.valueOf(loggingLevelSt.toUpperCase());

        return new FileLoggerConfiguration(loggerPath, loggingLevel, sizeLimit, format);
    }

 }
