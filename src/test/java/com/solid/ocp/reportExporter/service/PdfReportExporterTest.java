package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.model.Report;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PdfReportExporterTest {

    @Inject
    PdfReportExporter exporter;

    @Test
    void testExportReportShouldGenerateReportFile() throws IOException {
        Report report = new Report("test", "test", "pdf");
        exporter.exportReport(report);
        File expectedFile = new File(String.valueOf(Paths.get(report.getName() + "." + report.getType())));
        assertTrue(expectedFile.exists());
        expectedFile.delete();
    }

}