package com.user.controller;

import com.user.api.UserApi;
import com.user.model.User;
import com.user.service.UserService;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

public class UserController implements UserApi {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public Response createUser(User user) {
        return Response.status(Response.Status.CREATED)
                .entity(service.createUser(user))
                .build();
    }

    @Override
    public Response getUserById(UUID id) {
        return Response.status(Response.Status.OK)
                .entity(service.getUserById(id))
                .build();
    }

    @Override
    public Response getUserByEmail(String email) {
        return Response.status(Response.Status.OK)
                .entity(service.getUserByEmail(email))
                .build();
    }

    @Override
    public Response updateUser(UUID id, User user) {
        return Response.status(Response.Status.OK)
                .entity(service.updateUser(id, user))
                .build();
    }

    @Override
    public Response deleteUser(UUID id) {
        return Response.status(Response.Status.OK)
                .entity(service.deleteUser(id))
                .build();
    }

}
