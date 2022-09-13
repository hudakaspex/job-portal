package com.job.portal.Jobportal.Security.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExistException extends RuntimeException {
    private String message;

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
