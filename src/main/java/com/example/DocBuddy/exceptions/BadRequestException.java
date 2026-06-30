package com.example.DocBuddy.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String ex){
        super(ex);
    }
}
