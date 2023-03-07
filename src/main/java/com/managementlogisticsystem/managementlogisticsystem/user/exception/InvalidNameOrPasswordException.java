package com.managementlogisticsystem.managementlogisticsystem.user.exception;

public class InvalidNameOrPasswordException extends RuntimeException {

    public InvalidNameOrPasswordException(String message){
        super(message);
    }
}
