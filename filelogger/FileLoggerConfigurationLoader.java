package filelogger;

import filelogger.FileLoggerConfiguration;
import logger.LoggingLevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(File configFile) throws IOException {
        LoggingLevel logLevel = null;
        long maxSize = 0;
        String format = null;

        File logFile = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE":
                        logFile = new File(value);
                        logFile.createNewFile();
                        break;
                    case "LEVEL":
                        logLevel = LoggingLevel.valueOf(value.toUpperCase());
                        break;
                    case "MAX-SIZE":
                        maxSize = Long.parseLong(value);
                        break;
                    case "FORMAT":
                        format = value;
                        break;
                }
            }
        }

        return new FileLoggerConfiguration(logFile, logLevel, maxSize, format);
    }
}