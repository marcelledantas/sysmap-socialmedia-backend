package com.example.parrotsysmap.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String firstName;
    private String secondName;
    private String photoUrl;

    private String email;

    private List<String> followers = new java.util.ArrayList<>();
    private List<String> following = new java.util.ArrayList<>();

    public UserDTO(String firstName, String secondName, String photoUrl) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.photoUrl = photoUrl;
    }
}
