package com.example.com.example.messenger.database;

import com.example.com.example.messenger.model.Message;
import com.example.com.example.messenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    public static  Map<Long, Message> getMessages(){
        return messages;
    }
    public static  Map<String, Profile> getProfiles(){
        return profiles;
    }
}
