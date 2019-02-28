package com.example;
import org.glassfish.jersey.server.spi.Container;

import javax.ws.rs.*;
import javax.xml.ws.Response;
import java.net.URI;

@Path("helloworld")
@Produces("text/plain")
@Consumes("text/plain")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";

    @GET

    public String getHello() {
        return CLICHED_MESSAGE;
    }
    @Path("{usernameId}")
    @GET
//    public String updatenewhello (@QueryParam("username") String username){
//        return username;
//    }
//    public String test(@PathParam("usernameId") String id,@QueryParam("a") String a,@MatrixParam("b") String b){
    public String test(@PathParam("usernameId") String id, @MatrixParam("b") String b){
        return id + b;
    }

}