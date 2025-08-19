package com.patterns.singleton.service;

import jakarta.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Singleton
public class KafkaLogService implements LogService {

    @Channel("logs-out")
    Emitter<String> logEmitter;

    public void logInfo(String infoMessage) {
        logEmitter.send("[INFO] " + infoMessage);
    }

    public void logError(String errorMessage, Throwable error) {
        logEmitter.send("[ERROR] " + errorMessage);
    }
}
