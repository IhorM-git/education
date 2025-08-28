package com.patterns.builder.builder;

import com.patterns.builder.model.UserProfile;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserProfileBuilderTest {
    @Test
    void testBuildUserProfileWithAllFields() {
        UserProfile profile = new UserProfileBuilder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .email("john.doe@example.com")
                .phone("123-456-7890")
                .address("123 Main St")
                .build();

        assertEquals("John", profile.getFirstName());
        assertEquals("Doe", profile.getLastName());
        assertEquals(30, profile.getAge());
        assertEquals("john.doe@example.com", profile.getEmail());
        assertEquals("123-456-7890", profile.getPhone());
        assertEquals("123 Main St", profile.getAddress());
    }

    @Test
    void testBuildUserProfileWithPartialFields() {
        UserProfile profile = new UserProfileBuilder()
                .firstName("Alice")
                .email("alice@example.com")
                .build();

        assertEquals("Alice", profile.getFirstName());
        assertNull(profile.getLastName());
        assertNull(profile.getAge());
        assertEquals("alice@example.com", profile.getEmail());
        assertNull(profile.getPhone());
        assertNull(profile.getAddress());
    }

}