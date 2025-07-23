package com.solid.srp.userRegistration.service;

import com.solid.srp.userRegistration.dto.UserDTO;

public interface UserService {
    public Boolean registerUser(UserDTO userDTO);
}
