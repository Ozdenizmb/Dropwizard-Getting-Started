package com.user.service;

import com.user.model.User;

import java.util.UUID;

public interface UserService {

    UUID createUser(User user);
    User getUserById(UUID id);
    User getUserByEmail(String email);
    User updateUser(UUID id, User user);
    Boolean deleteUser(UUID id);

}
