package com.user.api;

import com.user.model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/api/v1/users")
public interface UserApi {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response createUser(User user);

    @GET
    @Path("/id/{id}")
    Response getUserById(@PathParam("id") UUID id);

    @GET
    @Path("/email/{email}")
    Response getUserByEmail(@PathParam("email") String email);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateUser(@PathParam("id") UUID id, User user);

    @DELETE
    @Path("/{id}")
    Response deleteUser(@PathParam("id") UUID id);

}
