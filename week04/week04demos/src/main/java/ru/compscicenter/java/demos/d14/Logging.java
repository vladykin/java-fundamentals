package ru.compscicenter.java.demos.d14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        LOGGER.info("Hello {}", "world");
    }
}
