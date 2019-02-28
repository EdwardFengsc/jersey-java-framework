package com.example.com.example.messenger.exception;

import com.example.com.example.messenger.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

//
//@Provider
//
//public class DataNotFoundExceptionMappe implements ExceptionMapper<RuntimeException>{
//    @Override
//    public Response toResponse(RuntimeException e) {
//        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(),404,"http://shichaofeng");
//        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
//    }
//
//
//}

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(),404,"http://shichaofeng");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
