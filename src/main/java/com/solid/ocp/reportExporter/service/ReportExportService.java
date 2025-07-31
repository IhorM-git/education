package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.dto.ReportDTO;
import com.solid.ocp.reportExporter.factory.ReportExporterFactory;
import com.solid.ocp.reportExporter.mapper.ReportMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.IOException;

@ApplicationScoped
public class ReportExportService {

    @Inject
    ReportExporterFactory factory;
    @Inject
    ReportMapper mapper;

    public void exportReport(ReportDTO reportDTO) throws IOException {
        ReportExporter exporter = factory.chooseReportExporter(reportDTO.getType());
        exporter.exportReport(mapper.toEntity(reportDTO));
    }
}
