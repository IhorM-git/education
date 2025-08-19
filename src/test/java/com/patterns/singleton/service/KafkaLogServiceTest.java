package com.patterns.singleton.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class KafkaLogServiceTest {

    @Inject
    LogService logger;

    @Inject
    LogService logger2;

    @Inject
    KafkaLogConsumer consumer;

    @Test
    void testLoggerShouldBeSingleton() {
        assertEquals(logger, logger2);
    }

    @Test
    void testLoggerLogShouldLogMessageToTerminal() throws InterruptedException {
        assertNotNull(logger);

        String infoMessage = "info test message";
        logger.logInfo(infoMessage);
        String errorMessage = "error test message";
        logger.logError(errorMessage, new Throwable("Error"));
        Thread.sleep(2000);

        List<String> logs = consumer.getLogs();
        assertTrue(logs.stream().anyMatch(m -> m.contains("[INFO] info test message")));
        assertTrue(logs.stream().anyMatch(m -> m.contains("[ERROR] error test message")));

    }

}