package com.solid.ocp.reportExporter.mapper;

import com.solid.ocp.reportExporter.dto.ReportDTO;
import com.solid.ocp.reportExporter.model.Report;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class ReportMapperTest {

    @Inject
    ReportMapper mapper;

    @Test
    void testToEntityShouldConvertDTOtoUserEntity() {
        ReportDTO reportDTO = new ReportDTO("reportName", "report test body", "csv");
        Report report = mapper.toEntity(reportDTO);
        assertNotNull(report);
        assertEquals(reportDTO.getName(), report.getName());
    }

    @Test
    void testToDTOShouldConvertEntityToUserDTO() {
        Report report = new Report("reportName", "report test body", "csv");
        ReportDTO reportDTO = mapper.toDTO(report);
        assertNotNull(report);
        assertEquals(report.getName(), reportDTO.getName());
    }


}