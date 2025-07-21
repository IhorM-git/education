package com.solid.srp.reportExample.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ApplicationScoped
public class ReportSaver {
    public void save(String fileName, String content) throws IOException {
        Files.writeString(Paths.get(fileName), content);
    }
}
