package com.user.management.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultStatus {

    public ResultStatus() {

    }
    public ResultStatus(String message,String status,String statusCode) {
        this.message = message;
        this.status = status;
        this.statusCode = statusCode;
    }

    private String statusCode;
    private String status;
    private String message;
}