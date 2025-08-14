package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.model.Report;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ApplicationScoped
public class XmlReportExporter implements ReportExporter {
    @Override
    public void exportReport(Report report) throws IOException {
        Files.writeString(Paths.get(report.getName() + "." + report.getType()), report.getBody());
    }
}
