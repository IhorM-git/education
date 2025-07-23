package com.solid.srp.userRegistration.validator;

import com.solid.srp.userRegistration.dto.UserDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class UserValidatorTest {

    @Inject
    UserValidator userValidator;

    @Test
    void testShouldValidateValidUser() {
        UserDTO userDTO =  new UserDTO("test@email.com", "Q1!wert8");
        assertTrue(userValidator.validate(userDTO));

    }
    @Test
    void testShouldValidateNotValidUser() {
        UserDTO userDTO =  new UserDTO("test.email.com", "Q1!wert");
        assertFalse(userValidator.validate(userDTO));
    }

}