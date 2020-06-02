package com.ttz.taungthuzay.log;

public final class LogManager {

    private static Logger logger = new LoggerDefault();

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger newLogger) {
        logger = newLogger;
    }

}
