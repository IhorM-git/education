package com.solid.ocp.reportExporter.service;

import com.solid.ocp.reportExporter.model.Report;

import java.io.IOException;

public interface ReportExporter {
    void exportReport(Report report) throws IOException;
}
