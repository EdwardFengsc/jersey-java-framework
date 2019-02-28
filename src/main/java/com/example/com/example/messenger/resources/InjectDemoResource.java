package com.example.com.example.messenger.resources;




import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String param,
                                            @HeaderParam("customHeaderValue") String header,
                                            @CookieParam("name") String cookie){
        return param + header + cookie;

    }
    @GET
    @Path("context")
    public String getParamUsingContext(@Context UriInfo urinfo, @Context HttpHeaders headers){
        String path = urinfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return path + cookies;

    }
}
