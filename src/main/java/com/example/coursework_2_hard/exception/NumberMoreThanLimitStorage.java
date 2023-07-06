package com.example.coursework_2_hard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberMoreThanLimitStorage extends RuntimeException{
    public NumberMoreThanLimitStorage() {
    }

    public NumberMoreThanLimitStorage(String message) {
        super(message);
    }

    public NumberMoreThanLimitStorage(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberMoreThanLimitStorage(Throwable cause) {
        super(cause);
    }

    public NumberMoreThanLimitStorage(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
