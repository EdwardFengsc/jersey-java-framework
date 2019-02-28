package com.example.com.example.messenger.service;

import com.example.com.example.messenger.database.DatabaseClass;
import com.example.com.example.messenger.exception.DataNotFoundException;
import com.example.com.example.messenger.model.Comment;
import com.example.com.example.messenger.model.ErrorMessage;
import com.example.com.example.messenger.model.Message;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    public List<Comment> getAllComments(long messageId){
        Message message = messages.get(messageId);
        if (message == null){
            throw new DataNotFoundException("Message with id： " + messageId + " Not found");
        }
        Map<Long, Comment> comments = message.getComments();
        if(comments.isEmpty() ){
            throw new DataNotFoundException("Message with id： " + messageId + " don't have comment," +
                    " please add comment first");
        }
        return new ArrayList<Comment>(comments.values());
    }
    public Comment getComment(long messageId, long commentId){
        Message message = messages.get(messageId);
        if(message == null){
            throw new DataNotFoundException("Message with id： "+ messageId+" not found");
        }
        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);
        if(comment == null){
//            ErrorMessage errorMessage = new ErrorMessage("Not have such commentId",404,"http://shichaofeng");
//            Response response = Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
//            throw new WebApplicationException(response);
            throw new DataNotFoundException("Message with id " + messageId +
                    " and Comment with id "+ commentId+" not found");
        }
        return comment;
    }
    public Comment addComment(long messageId, Comment comment){
        Message message = messages.get(messageId);
        if (message == null){
            throw new DataNotFoundException("Message with id： "+ messageId+" Not Found");
        }
        Map<Long,Comment> comments = message.getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }
    public Comment updateComment(long messageId, Comment comment){
        Message message = messages.get(messageId);
        if (message == null){
            throw new DataNotFoundException("Message with id： "+ messageId+" not Found");
        }
        Map<Long, Comment> comments = message.getComments();
        if(comment.getId() <= 0){
            throw new DataNotFoundException("Message with id： " + messageId + " don't have comment," +
                    " please add comment first");
        }
        comments.put(comment.getId(), comment);
        return comments.get(comment.getId());
    }
    public Map<Long, Comment> removeComment(long messageId, long commentId){
        Message message = messages.get(messageId);
        if (message == null){
            throw new DataNotFoundException("Message with Id： "+ messageId+" not found");
        }
        Map<Long,Comment> comments = message.getComments();
        if (comments.isEmpty()){
            throw new DataNotFoundException("Message with id： " + messageId + " don't have comment," +
                    " please add comment first");
        }
        else if (comments.get(commentId) == null){
            throw new DataNotFoundException("Message with id " + messageId +
                    " and Comment with id "+ commentId+" not found");
        }
        comments.remove(commentId);
        return messages.get(messageId).getComments();
    }
}
