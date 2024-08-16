package com.dilshan.login.Register.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;


@Getter
public enum BusinessErrorCode {

    NO_CODE(0,NOT_IMPLEMENTED,"No code"),

    INCORRECT_CURRENT_PASSWORD(300,BAD_REQUEST,"Current Password is incorrect"),

    NEW_PASSWORD_DOES_NOT_MATCH(301,BAD_REQUEST,"New Password does not match"),

    ACCOUNT_LOCKED(302,FORBIDDEN,"User Account is Locked"),

    ACCOUNT_DISABLED(303,FORBIDDEN,"User Account is disabled"),

    BAD_CREDENTIALS(304,FORBIDDEN,"Login and / or password is incorrect")
    ;

    private final int code;

    private final String description;

    private final HttpStatus httpStatus;

    BusinessErrorCode(int code,HttpStatus httpStatus,String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
