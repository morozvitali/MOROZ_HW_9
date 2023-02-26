package src.main.java.hillel.hw.filelogger;

import src.main.java.hillel.hw.logger.LoggingLevel;

import java.io.File;

public class FileLoggerConfiguration {

    private File logFile;
    private LoggingLevel logLevel;
    private long maxFileSize;
    private String fileFormat;

    public FileLoggerConfiguration(File logFile, LoggingLevel logLevel, long maxFileSize, String fileFormat) {
        this.logFile = logFile;
        this.logLevel = logLevel;
        this.maxFileSize = maxFileSize;
        this.fileFormat = fileFormat;
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LoggingLevel logLevel) {
        this.logLevel = logLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}