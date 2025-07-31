package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.model.Report;
import jakarta.enterprise.context.ApplicationScoped;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

@ApplicationScoped
public class PdfReportExporter implements ReportExporter {

    @Override
    public void exportReport(Report report) throws IOException {
        PDDocument document = new PDDocument();
        //Create page
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        //Create content
        try (PDPageContentStream content = new PDPageContentStream(document, page)) {
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 16);
            content.newLineAtOffset(100, 700);
            content.showText(report.getBody());
            content.endText();
        }

        //Save pdf
        document.save(report.getName() + "." + report.getType());
    }
}
