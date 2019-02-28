package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("users/{username: [a-zA-Z][a-zA-Z_0-9]*}")
public class UserResource {

    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        return userName;
    }
}