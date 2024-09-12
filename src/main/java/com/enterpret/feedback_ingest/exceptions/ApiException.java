package com.enterpret.feedback_ingest.exceptions;

public class ApiException extends Exception {

    public ApiException(Exception ex, String message) {
        super(message, ex);
    }

}
