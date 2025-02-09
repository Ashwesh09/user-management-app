package com.user.management.app.exception;

public class UserManagementException extends Exception {
    private static final long serialVersionUID = 1L;
    public UserManagementException() {
        super();
    }

    public UserManagementException(String message) {
        super(message);
    }

    public UserManagementException(String message, Throwable cause) {
        super(message, cause);
    }



}
