package com.example.socialmediasysmap.dtos;

import java.util.List;

public class UserDTO {
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private String photo;

    private List<String> followers = new java.util.ArrayList<>();
    private List<String> following = new java.util.ArrayList<>();

    public UserDTO(String firstName, String secondName, String login, String password, String photo, List<String> followers, List<String> following) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.photo = photo;
        this.followers = followers;
        this.following = following;
    }
}
