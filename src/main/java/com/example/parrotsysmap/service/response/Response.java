package com.example.parrotsysmap.service.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response <T>{

    private T data;
    private List<String> errors;

    private String message;

    private String Status;

    public List<String> getErrors(){
        if(this.errors == null){
            this.errors = new ArrayList<String>();
        }
        return this.errors;
    }
}
