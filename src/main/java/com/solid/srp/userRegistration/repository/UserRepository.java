package com.solid.srp.userRegistration.repository;

import com.solid.srp.userRegistration.model.User;

public interface UserRepository {
    void create(User user);
    User getByEmail(String email);
    void deleteByEmail(String email);
}
