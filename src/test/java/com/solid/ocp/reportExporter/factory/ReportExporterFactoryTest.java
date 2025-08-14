package com.solid.ocp.reportExporter.factory;

import com.solid.ocp.reportExporter.service.CsvReportExporter;
import com.solid.ocp.reportExporter.service.PdfReportExporter;
import com.solid.ocp.reportExporter.service.ReportExporter;
import com.solid.ocp.reportExporter.service.XmlReportExporter;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ReportExporterFactoryTest {
    @Inject
    ReportExporterFactory factory;

    @Test
    public void testChooseStrategyShouldReturnCorrectStrategy() {
        ReportExporter csvStrategy = factory.chooseReportExporter("csv");
        ReportExporter pdfStrategy = factory.chooseReportExporter("pdf");
        ReportExporter xmlStrategy = factory.chooseReportExporter("xml");
        assertNotNull(csvStrategy);
        assertNotNull(pdfStrategy);
        assertNotNull(xmlStrategy);
        assertInstanceOf(CsvReportExporter.class, csvStrategy);
        assertInstanceOf(PdfReportExporter.class, pdfStrategy);
        assertInstanceOf(XmlReportExporter.class, xmlStrategy);
    }

}