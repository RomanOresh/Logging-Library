package app.consolelogger;

import app.LoggingLevel;
import app.filelogger.FileLoggerConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConsoleLoggerConfigurationLoader {

    private static final String CONFIG_PATH = "src/main/config/logger.config";

    public static ConsoleLoggerConfiguration load() {
        Properties props = new Properties();
        try (FileInputStream fin = new FileInputStream(CONFIG_PATH)) {
            props.load(fin);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке файла конфигурации: " + e.getMessage());
            return new ConsoleLoggerConfiguration();
        }
        String loggingLevelSt = props.getProperty("LEVEL");
        String format = props.getProperty("FORMAT");
        LoggingLevel loggingLevel = LoggingLevel.valueOf(loggingLevelSt.toUpperCase());

        return new ConsoleLoggerConfiguration(format, loggingLevel);
    }
}
