package com.example.com.example.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@XmlRootElement
public class Profile {
    private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;


//    @Override
//    public String toString() {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        String strDate = dateFormat.format(this.created);
//        return String.format("id = %d, profileName = %s, firstName = %s, lastName= %s, date = %s"
//                , this.id, this.profileName, this.firstName, this.lastName,strDate);
//    }

    public Profile(long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.created = new Date();
        this.lastName = lastName;

    }

    public Profile(){

    }

    public long getId() {
        return id;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

