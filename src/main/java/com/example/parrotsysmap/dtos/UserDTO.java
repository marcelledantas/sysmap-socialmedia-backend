package com.example.parrotsysmap.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String fullName;
    private String photoUrl;
    private String email;

    private List<String> followers = new java.util.ArrayList<>();
    private List<String> following = new java.util.ArrayList<>();

    public UserDTO(String fullName, String photoUrl, String email) {
        this.fullName = fullName;
        this.photoUrl = photoUrl;
        this.email = email;
    }
}
