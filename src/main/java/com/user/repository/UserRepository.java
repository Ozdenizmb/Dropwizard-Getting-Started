package com.user.repository;

import com.user.model.User;

import java.util.UUID;

public interface UserRepository {

    UUID save(User user);
    User getById(UUID id);
    User getByEmail(String email);
    User update(UUID id, User user);
    Boolean delete(UUID id);

}
