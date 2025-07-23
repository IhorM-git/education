package com.solid.srp.userRegistration.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PasswordValidatorTest {
    PasswordValidator validator = new PasswordValidator();

    @Test
    public void testIsValidShouldProcessValidPassword() {
        String validUserPassword = "1Qq!qwer";
        assertTrue(validator.isValid(validUserPassword));
    }

    @Test
    public void testIsValidShouldFailIfPasswordEmptyOrNull() {
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(null));
    }

    @Test
    public void testIsValidShouldCheckMinimumLength() {
        String password = "1Qq!qwe";
        assertFalse(validator.isValid(password));
    }

    @Test
    public void testIsValidShouldCheckCapitalLetter() {
        String password = "1qq!qwer";
        assertFalse(validator.isValid(password));
    }

    @Test
    public void testIsValidShouldCheckSmallLetter() {
        String password = "1QQ!QWER";
        assertFalse(validator.isValid(password));
    }

    @Test
    public void testIsValidShouldCheckSpecialCharacter() {
        String password = "1Qq1qwer";
        assertFalse(validator.isValid(password));
    }

    @Test
    public void testIsValidShouldCheckNumber() {
        String password = "!Qq!qwer";
        assertFalse(validator.isValid(password));
    }


}