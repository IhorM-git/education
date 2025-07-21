package com.solid.srp.reportExample.api;

import com.solid.srp.reportExample.dto.ReportDTO;
import com.solid.srp.reportExample.service.ReportExporter;
import com.solid.srp.reportExample.service.ReportGenerator;
import com.solid.srp.reportExample.service.ReportSaver;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("/solid/srp/report")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.APPLICATION_JSON)
public class ReportResource {

    @Inject
    ReportGenerator generator;
    @Inject
    ReportExporter exporter;
    @Inject
    ReportSaver saver;

    @POST
    public Response createReport(ReportDTO dto){
        try {
            var report = generator.generateReport(dto.title, dto.content);
            var json = exporter.toJson(report);
            saver.save("report.json", json);

            return Response.status(Response.Status.CREATED).entity(json).build();
        } catch (IOException e) {
            return Response.serverError().entity("Failed: " + e.getMessage()).build();
        }
    }

}
