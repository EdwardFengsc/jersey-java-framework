package com.example.com.example.messenger.resources;


import com.example.com.example.messenger.model.Profile;
import com.example.com.example.messenger.service.ProfileService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Singleton
@Path("/profiles")

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
    ProfileService profileService = new ProfileService();
    @GET
    public List<Profile> getAllProfiles(){
        return profileService.getAllprofile();
    }
    @POST
    public Profile addProfiles(Profile profile){
        return profileService.addProfile(profile);
    }
    @PUT
    @Path("{profileName}")
    public Profile updateProfiles(@PathParam("profileName") String profileName, Profile profile){
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }
    @DELETE
    @Path("{profileName}")
    public List<Profile> deleteProfiles(@PathParam("profileName") String profileName){
        profileService.removeProfile(profileName);
        return profileService.getAllprofile();

    }
    @GET
    @Path("{profileName}")
    public Profile getProfiles(@PathParam("profileName") String profileName){
        return profileService.getProfile(profileName);
    }

}
