package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class PersonResourceTest {
    @Test
    public void testPostAndGet() {
        RestAssured
                .given()
                .contentType("application/json")
                .body("{\"name\":\"Ігор\", \"age\":30}")
                .when()
                .post("/persons")
                .then()
                .statusCode(204);

        RestAssured
                .when().get("/persons")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("[0].name", notNullValue());
    }
}
