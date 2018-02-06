package com.otoil.ot_118_rest.response;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
public class ErrorResponse {
    public int status;
    public String error;
    public String message;

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}