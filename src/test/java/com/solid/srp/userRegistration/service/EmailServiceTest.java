package com.solid.srp.userRegistration.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EmailServiceTest {
    @Inject
    EmailService emailService;

    @Test
    void testSendEmailShouldSendEmail() {
        String email = "local@localhost";
        emailService.send(email);
        assertNotNull(emailService);
    }

}