package com.solid.ocp.reportExporter.resource;

import com.solid.ocp.reportExporter.dto.ReportDTO;
import com.solid.ocp.reportExporter.service.ReportExportService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/solid/ocp/report/export")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReportResource {
    @Inject
    ReportExportService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(ReportDTO reportDTO) {
        try {
            service.exportReport(reportDTO);
            return Response.status(Response.Status.CREATED).entity(reportDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
