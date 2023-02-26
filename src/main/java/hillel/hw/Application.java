package src.main.java.hillel.hw;

import src.main.java.hillel.hw.filelogger.FileLogger;
import src.main.java.hillel.hw.filelogger.FileLoggerConfiguration;
import src.main.java.hillel.hw.filelogger.FileLoggerConfigurationLoader;

public class Application {
    private final static String PATH = "src/main/java/hillel/hw/logger/property.properties";
    public static void main(String[] args) {
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Помилка 10012");
        fileLogger.debug("Помилок не знайдено");
        fileLogger.info("Система штатно увімкнена, спорядження працює у звичайному режимі");
        fileLogger.info("Знайдено нове устаткування");
        fileLogger.info("Устаткування від'єднано");
    }
}