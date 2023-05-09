package com.example.parrotsysmap.exception;

public class EmailAlreadyExistsException extends Exception{

    public EmailAlreadyExistsException() {
        super("Este email já está vinculado a um usuário");
    }
}
