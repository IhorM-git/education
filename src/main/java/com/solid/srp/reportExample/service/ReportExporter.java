package com.solid.srp.reportExample.service;

import com.solid.srp.reportExample.model.Report;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

@ApplicationScoped
public class ReportExporter {
    public String toJson(Report report) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(report);
    }
}
