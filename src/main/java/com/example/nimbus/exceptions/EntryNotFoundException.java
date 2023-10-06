package com.example.nimbus.exceptions;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(String message){
        super(message);
    }
}
