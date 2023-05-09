package com.example.parrotsysmap.dtos;

import lombok.Data;

@Data
public class ResponseDTO {
    private String status;
    private String message;

    public ResponseDTO(String status, String message, Object payload) {
        this.status = status;
        this.message = message;
    }
}
