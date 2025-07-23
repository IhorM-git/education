package com.solid.srp.userRegistration.repository;

import com.solid.srp.userRegistration.model.User;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class UserRepositoryTest {
    String testEmail = "test@test.com";
    @Inject
    UserRepository repository;

    @AfterEach
    public void teardown() {
        removeTestUser();
    }

    @Test
    public void testCreateShouldCreateNewUser() {
        User user = new User(testEmail, "pwd1!qqq8");
        repository.create(user);
        User createdUser = repository.getByEmail(user.getEmail());
        assertNotNull(createdUser);
        assertEquals(user.getEmail(), createdUser.getEmail());
    }


    private void removeTestUser() {
        repository.deleteByEmail(testEmail);
    }

}