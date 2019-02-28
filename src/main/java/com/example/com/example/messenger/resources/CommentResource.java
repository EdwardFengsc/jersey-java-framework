package com.example.com.example.messenger.resources;

import com.example.com.example.messenger.model.Comment;
import com.example.com.example.messenger.service.CommentService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
    private CommentService commentService = new CommentService();
    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId){
        return commentService.getAllComments(messageId);
    }
    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
        return commentService.addComment(messageId,comment);
    }
    @GET
    @Path("{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId){
        return commentService.getComment(messageId,commentId);
    }
    @PUT
    @Path("{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long commentId,
                                 Comment comment){
        comment.setId(commentId);
        return commentService.updateComment(messageId,comment);
    }
    @DELETE
    @Path("{commentId}")
    public Map<Long, Comment> deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
        return commentService.removeComment(messageId, commentId);
    }

}
