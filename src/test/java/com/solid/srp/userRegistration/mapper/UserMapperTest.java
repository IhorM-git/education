package com.solid.srp.userRegistration.mapper;

import com.solid.srp.userRegistration.dto.UserDTO;
import com.solid.srp.userRegistration.model.User;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserMapperTest {
    @Inject
    UserMapper mapper;

    @Test
    void testToEntityShouldConvertDTOtoUserEntity() {
        UserDTO userDTO = new UserDTO("test@email.com", "password");
        User user = mapper.toEntity(userDTO);
        assertNotNull(user);
        assertEquals(userDTO.getEmail(), user.getEmail());
    }

    @Test
    void testToDTOShouldConvertEntityToUserDTO() {
        User user = new User("test@email.com", "password");
        UserDTO userDTO = mapper.toDTO(user);
        assertNotNull(userDTO);
        assertEquals(user.getEmail(), userDTO.getEmail());
    }

}