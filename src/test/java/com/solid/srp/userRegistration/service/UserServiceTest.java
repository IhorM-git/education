package com.solid.srp.userRegistration.service;

import com.solid.srp.userRegistration.dto.UserDTO;
import com.solid.srp.userRegistration.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class UserServiceTest {
    String testEmail = "test@test.com";

    @Inject
    UserService service;
    @Inject
    UserRepository repository;

    @Test
    void testRegisterUserRegisterUser() {
        UserDTO userDTO =  new UserDTO(testEmail, "Q1!wert8");
        Boolean isRegistered = service.registerUser(userDTO);
        assertTrue(isRegistered);
        repository.deleteByEmail(testEmail);
    }

    @Test
    void testRegisterUserShouldNotRegisterUser() {
        UserDTO userDTO =  new UserDTO(testEmail, "Q1!wert");
        Boolean isRegistered = service.registerUser(userDTO);
        assertFalse(isRegistered);
    }

}