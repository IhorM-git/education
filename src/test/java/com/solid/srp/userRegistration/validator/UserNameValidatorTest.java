package com.solid.srp.userRegistration.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserNameValidatorTest {
    UserNameValidator validator = new UserNameValidator();

    @Test
    public void testIsValidShouldReturnTrue() {
        String validUserName = "valid_user_name";
        assertTrue(validator.isValid(validUserName));
    }

    @Test
    public void testIsValidShouldFailIfUserNameEmptyOrNull() {
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(null));
    }

    @Test
    public void testIsValidShouldFailIfUserNameLengthNotValid() {
        assertFalse(validator.isValid(""));
        assertFalse(validator.isValid(null));
    }

}