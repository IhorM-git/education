package com.solid.ocp.reportExporter.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class ReportResourceTest {
    @Test
    public void testPostAndGet() {

        RestAssured
                .given()
                .contentType("application/json")
                .body("{\"name\":\"test\", \"body\":\"test\", \"type\":\"csv\"}")
                .when()
                .post("/solid/ocp/report/export")
                .then()
                .statusCode(201);

        File expectedFile = new File("test.csv");
        assertTrue(expectedFile.exists());
        expectedFile.delete();
    }
}