package com.solid.ocp.reportExporter.factory;

import com.solid.ocp.reportExporter.service.CsvReportExporter;
import com.solid.ocp.reportExporter.service.PdfReportExporter;
import com.solid.ocp.reportExporter.service.ReportExporter;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReportExporterFactory {
    public ReportExporter chooseReportExporter(String reportType) {
        return switch (reportType) {
            case "csv" -> new CsvReportExporter();
            case "pdf" -> new PdfReportExporter();
            default -> throw new IllegalArgumentException("Unknown type: " + reportType);
        };
    }
}
