package com.remindme.admin.exception.custom;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message, Long id) {
        super(String.format(message, id));
    }

}
