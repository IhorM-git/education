package com.solid.srp.userRegistration.validator;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public Boolean isValid(String password) {
        if (password == null || password.isBlank()) return false;
        return PASSWORD_PATTERN.matcher(password).matches();
    }
}
