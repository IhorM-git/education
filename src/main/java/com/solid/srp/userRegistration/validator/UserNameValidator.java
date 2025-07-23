package com.solid.srp.userRegistration.validator;

public class UserNameValidator {

    public boolean isValid(String userName) {
        if (userName == null || userName.isBlank()) return false;

        int minimumUserNameLength = 4;
        if (userName.length() < minimumUserNameLength) return false;

        return true;
    }
}
