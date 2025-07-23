package com.solid.srp.userRegistration.resource;

import com.solid.srp.userRegistration.dto.UserDTO;
import com.solid.srp.userRegistration.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/solid/srp/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(UserDTO userDTO) {
        try {
            Boolean isRegistered = userService.registerUser(userDTO);
            if (isRegistered) { return Response.status(Response.Status.CREATED).entity(userDTO).build(); }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
