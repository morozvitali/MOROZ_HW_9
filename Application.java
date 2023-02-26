public class Application {
    private final static String PATH = "property.properties";
    public static void main(String[] args) {
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load();
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Hello world!");
        fileLogger.debug("Hello world!");
        fileLogger.info("info message");
        fileLogger.info("info message");
        fileLogger.info("info message");
    }
}