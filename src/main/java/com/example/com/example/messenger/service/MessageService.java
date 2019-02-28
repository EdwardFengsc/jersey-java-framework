package com.example.com.example.messenger.service;

import com.example.com.example.messenger.database.DatabaseClass;
import com.example.com.example.messenger.exception.DataNotFoundException;
import com.example.com.example.messenger.model.Comment;
import com.example.com.example.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long,Message> messages = DatabaseClass.getMessages();
    public MessageService(){
//        System.out.println("test!!!");
        messages.put(1L,new Message(1,"Hello world","shichao feng"));
        messages.put(2L,new Message(2,"Hello jersey","shichao feng"));
        Map<Long, Comment> comments = messages.get(1L).getComments();
        comments.put(1L,new Comment(1,"jzy aaaaa","shichaofeng"));
        comments.put(2L,new Comment(2,"jzy bbbbb","shichao feng"));
//        System.out.println("nooooooo!!!");
    }
    public List<Message> getAllmessages(){
        if (messages.isEmpty()){
            throw new DataNotFoundException("There is no message existed yet！");
        }
        return new ArrayList<Message> (messages.values());

    }
    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message: messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }
    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        if (start + size > list.size()){
            return new ArrayList<Message>();
        }
        return list.subList(start, start + size);

    }
    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(),message);
        return message;
    }
    public Message updateMessage(Message message){
        long id = message.getId();

        if (id <= 0){
            return null;
        }


//        System.out.println("BEFORE:");
//        for (long i = 1; i <= messages.size(); i++) {
//            System.out.println(messages.get(i));
//        }

        messages.put(id,message);

//        System.out.println("\nAFTER:");
//        for (long i = 1; i <= messages.size(); i++) {
//            System.out.println(messages.get(i));
//        }
//        for (Message msg : getAllmessages()) {
//            System.out.println(msg);
//        }


        return messages.get(id);
    }
    public List<Message> removeMessage(long id){
        if (messages.get(id) == null){
            throw new DataNotFoundException("Message with id： " + id + " Not found");
        }
        messages.remove(id);
        return getAllmessages();
    }
    public Message getMessage(long id){

        Message message =  messages.get(id);
        if (message == null){
            throw new DataNotFoundException("Message with id "+ id+" not found");
        }
        return message;
    }
}
