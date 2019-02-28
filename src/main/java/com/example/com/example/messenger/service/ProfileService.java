package com.example.com.example.messenger.service;

import com.example.com.example.messenger.database.DatabaseClass;
import com.example.com.example.messenger.exception.DataNotFoundException;
import com.example.com.example.messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService(){
        profiles.put("shichaofeng",new Profile(1,"shichaofeng","shichao","feng"));
        profiles.put("zhiyuanjia",new Profile(2,"zhiyuanjia","zhiyuan","jia"));
    }
    public List<Profile> getAllprofile(){

        if (profiles.isEmpty()){
            throw new DataNotFoundException("There is no profile existed yet！");
        }return new ArrayList<Profile>(profiles.values());
    }
    public Profile getProfile(String profileName){
        Profile profile = profiles.get(profileName);
        if (profile == null){
            throw new DataNotFoundException("Profile with profileName "+ profileName +" not found");
        }
        return profile;
    }
    public Profile addProfile(Profile profile){
        profile.setId(profiles.size() + 1);
//        System.out.println(profile);
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }
    public Profile updateProfile(Profile profile){
        if (profile.getProfileName().isEmpty()){
            return null;
        }
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }
    public List<Profile> removeProfile(String profileName){
        if (profiles.get(profileName) == null){
            throw new DataNotFoundException("Profile with profileName： " + profileName + " Not found");
        }
        profiles.remove(profileName);
        return getAllprofile();
    }
}
