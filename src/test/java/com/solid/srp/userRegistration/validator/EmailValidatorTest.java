package com.solid.srp.userRegistration.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class EmailValidatorTest {
    EmailValidator validator = new EmailValidator();

    @Test
    public void testIsValidShouldReturnTrue() {
        String validUserEmail = "valid.email@mail.com";
        assertTrue(validator.isValid(validUserEmail));
    }

    @Test
    public void testIsValidShouldFailValidationAndReturnFalse() {
        String notValidUserEmail = "not.valid.email.com";
        assertFalse(validator.isValid(notValidUserEmail));
    }

    @Test
    public void testIsValidShouldFailIfEmailEmptyOrNull() {
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(null));
    }

}