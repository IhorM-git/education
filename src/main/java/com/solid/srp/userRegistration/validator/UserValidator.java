package com.solid.srp.userRegistration.validator;

import com.solid.srp.userRegistration.dto.UserDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserValidator {

    @Inject
    EmailValidator emailValidator;
    @Inject
    PasswordValidator passwordValidator;

    public boolean validate(UserDTO userDTO) {
        Boolean isValid = true;
        isValid = emailValidator.isValid(userDTO.getEmail());
        isValid = passwordValidator.isValid(userDTO.getPassword());
        return isValid;
    }
}
