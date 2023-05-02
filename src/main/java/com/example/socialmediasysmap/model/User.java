package com.example.socialmediasysmap.model;
import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;

    private List<String> followers = new java.util.ArrayList<>();
    private List<String> following = new java.util.ArrayList<>();

}
