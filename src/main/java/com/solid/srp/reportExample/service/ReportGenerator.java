package com.solid.srp.reportExample.service;

import com.solid.srp.reportExample.model.Report;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReportGenerator {
    public Report generateReport(String title, String content) {
        return new Report(title, content);
    }

}
