package com.example.demoapplication;

public class userModelClass {
    private String id,userEmail,firstName,lastName,userProfile;

    public userModelClass(String id, String userEmail, String firstName, String lastName, String userProfile) {
        this.id = id;
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userProfile = userProfile;
    }

    public userModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }
}
