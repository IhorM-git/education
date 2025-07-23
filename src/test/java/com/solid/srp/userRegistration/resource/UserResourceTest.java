package com.solid.srp.userRegistration.resource;

import com.solid.srp.userRegistration.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserResourceTest {
    @Inject
    UserRepository repository;

    @Test
    public void testPostAndGet() {
        RestAssured
                .given()
                .contentType("application/json")
                .body("{\"email\":\"test@email.com\", \"password\":\"Q1!wert8\"}")
                .when()
                .post("/solid/srp/register")
                .then()
                .statusCode(201);

        repository.deleteByEmail("test@email.com");
    }

}