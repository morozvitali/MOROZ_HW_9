package src.main.java.hillel.hw.logger;

public enum LoggingLevel {
    INFO,
    DEBUG;
    private static LoggingLevel currentLevel = INFO;

    public static void setLevel(LoggingLevel level) {
        currentLevel = level;
    }

    public static boolean isLevelEnabled(LoggingLevel level) {
        if (currentLevel == DEBUG) {
            return true;
        } else if (currentLevel == INFO && level == INFO) {
            return true;
        } else {
            return false;
        }
    }
}