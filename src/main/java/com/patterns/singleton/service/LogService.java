package com.patterns.singleton.service;

public interface LogService {
    void logInfo(String infoMessage);
    void logError(String errorMessage, Throwable error);
}
