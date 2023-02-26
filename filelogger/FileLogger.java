package filelogger;

import logger.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class FileLogger  {
    private final FileLoggerConfiguration config;
    private File currentFile;
    private long currentFileSize;
    private BufferedWriter writer;

    public FileLogger(FileLoggerConfiguration config) throws IOException {
        this.config = config;
        this.currentFile = newLogFile();
        this.writer = new BufferedWriter(new FileWriter(currentFile));
    }
    public void info(String message) throws IOException {
        log(message, LoggingLevel.INFO);
    }
    protected void logMessage(String message) {

    }
    public void debug(String message) throws IOException {
        log(message, LoggingLevel.DEBUG);
    }
    private void log(String message, LoggingLevel level) throws IOException {
        if (level.compareTo(config.getLogLevel()) < 0) {
            return;
        }
        String logMessage = String.format("[%s][%s] Message: %s\n",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level,
                message);

        synchronized (this) {
            if (currentFileSize + logMessage.length() > config.getMaxFileSize()) {
                rotateLogFile();
            }
            writer.write(logMessage);
            writer.flush();
            currentFileSize += logMessage.length();
        }
    }
    private File newLogFile() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        String fileName = String.format("Log_%s.txt", now.format(ofPattern("dd.MM.yyyy-HH-mm")));
        File file = new File(config.getLogFile().getParentFile(), fileName);
        file.createNewFile();
        return file;
    }

    private void rotateLogFile() throws IOException {
        writer.close();
        currentFile = newLogFile();
        writer = new BufferedWriter(new FileWriter(currentFile));
        currentFileSize = 0;
    }
}