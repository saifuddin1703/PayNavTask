package com.example.paynavtask.models;

public class usermodel {
    String name;
    int profilepicture;

    public String getName() {
        return name;
    }

    public int getProfilepicture() {
        return profilepicture;
    }

    public usermodel(String name, int profilepicture) {
        this.name = name;
        this.profilepicture = profilepicture;
    }
}
