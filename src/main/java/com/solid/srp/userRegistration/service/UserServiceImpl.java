package com.solid.srp.userRegistration.service;

import com.solid.srp.userRegistration.dto.UserDTO;
import com.solid.srp.userRegistration.mapper.UserMapper;
import com.solid.srp.userRegistration.repository.UserRepository;
import com.solid.srp.userRegistration.validator.UserValidator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;
    @Inject
    UserMapper userMapper;
    @Inject
    UserValidator userValidator;
    @Inject
    @Named("email")
    NotificationService notificationService;

    public Boolean registerUser(UserDTO userDTO) {
        try {
            if (!userValidator.validate(userDTO)) return false;
            userRepository.create(userMapper.toEntity(userDTO));

            notificationService.send(userDTO.getEmail());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
