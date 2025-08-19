package com.patterns.singleton.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class KafkaLogConsumer {
    private final List<String> logs = new ArrayList<>();

    @Incoming("logs-in")
    public void consume(String log) {
        logs.add(log);
    }

    public List<String> getLogs() {
        return logs;
    }
}
