package com.example.com.example.messenger.resources;

import com.example.com.example.messenger.model.Message;
import com.example.com.example.messenger.service.MessageService;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
@Singleton
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessengeResource {
    MessageService messageService = new MessageService();
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean){
        if(filterBean.getYear() > 0) {
            return messageService.getAllMessagesForYear(filterBean.getYear());
        }
        if(filterBean.getStart() >= 0 && filterBean.getSize() > 0){
            return messageService.getAllMessagesPaginated(filterBean.getStart(),filterBean.getSize());
        }
        return messageService.getAllmessages();
    }


    @POST
    public Response addMessages(Message message, @Context UriInfo uriinfo){
        Message newmessage = messageService.addMessage(message);
        String newId = String.valueOf(newmessage.getId());
        return Response.created(uriinfo.getAbsolutePathBuilder().path(newId).build()).entity(newmessage).build();
    }

    @PUT
    @Path("{messageId}")
    public Message updateMessages(@PathParam("messageId") long id, Message message){
//        System.out.println("updateMessages");
//        System.out.println(id);
//
//
//        System.out.println(message);
//
//        System.out.println("-");


        message.setId(id);
//        System.out.println(message);

        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("{messageId}")
    public List<Message> deleteMessages(@PathParam("messageId") long id, Message message){
        return messageService.removeMessage(id);
    }

    @GET
    @Path("{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @Path("{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}
