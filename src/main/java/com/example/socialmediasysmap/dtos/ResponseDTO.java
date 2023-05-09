package com.example.socialmediasysmap.dtos;

public class ResponseDTO {
    private String status;
    private String message;

    public ResponseDTO(String status, String message, Object payload) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
