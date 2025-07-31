package com.solid.ocp.reportExporter.mapper;

import com.solid.ocp.reportExporter.dto.ReportDTO;
import com.solid.ocp.reportExporter.model.Report;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReportMapper {

    public Report toEntity(ReportDTO reportDTO) {
        Report report = new Report();
        report.setName(reportDTO.getName());
        report.setBody(reportDTO.getBody());
        report.setType(reportDTO.getType());
        return report;
    }

    public ReportDTO toDTO(Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setName(report.getName());
        reportDTO.setBody(report.getBody());
        reportDTO.setType(report.getType());
        return reportDTO;
    }
}
