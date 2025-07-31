package com.solid.ocp.reportExporter.dto;

public class ReportDTO {

    private String name;
    private String body;
    private String type;

    public ReportDTO() {
    }

    public ReportDTO(String name, String body, String type) {
        this.name = name;
        this.body = body;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
