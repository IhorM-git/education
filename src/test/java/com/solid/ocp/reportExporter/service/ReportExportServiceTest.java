package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.dto.ReportDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ReportExportServiceTest {

    @Inject
    ReportExportService service;

    @Test
    void testExportReportShouldExportCsvReport() throws IOException {
        ReportDTO reportDTO = new ReportDTO("test", "test", "csv");
        service.exportReport(reportDTO);
        File expectedFile = new File(String.valueOf(Paths.get(reportDTO.getName() + "." + reportDTO.getType())));
        assertTrue(expectedFile.exists());
        expectedFile.delete();
    }

    @Test
    void testExportReportShouldExportPdfReport() throws IOException {
        ReportDTO reportDTO = new ReportDTO("test", "test", "pdf");
        service.exportReport(reportDTO);
        File expectedFile = new File(String.valueOf(Paths.get(reportDTO.getName() + "." + reportDTO.getType())));
        assertTrue(expectedFile.exists());
        expectedFile.delete();
    }

    @Test
    void testExportReportShouldExportXmlReport() throws IOException {
        ReportDTO reportDTO = new ReportDTO("test", "test", "xml");
        service.exportReport(reportDTO);
        File expectedFile = new File(String.valueOf(Paths.get(reportDTO.getName() + "." + reportDTO.getType())));
        assertTrue(expectedFile.exists());
        expectedFile.delete();
    }

}