package com.user.service.impl;

import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        return repository.getById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User updateUser(UUID id, User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(UUID id) {
        return null;
    }

}
