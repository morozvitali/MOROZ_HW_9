public class FileLoggerConfiguration {
    private final String path;
    private final LoggingLevel loggingLevel;
    private final int maxFileSize;
    private final String format;

    public FileLoggerConfiguration(String path,
                                   LoggingLevel loggingLevel,
                                   int maxFileSize,
                                   String format
    ) {
        this.path = path;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public int getSizeLimit() {
        return maxFileSize;
    }

    public String getFormat() {
        return format;
    }
}