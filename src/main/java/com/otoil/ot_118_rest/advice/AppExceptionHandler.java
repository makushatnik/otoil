package com.otoil.ot_118_rest.advice;

import com.otoil.ot_118_rest.exceptions.ConflictException;
import com.otoil.ot_118_rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ErrorResponse handleNotFound(EntityNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(HttpServletResponse.SC_NOT_FOUND, "Error", ex.getMessage());
        //return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
        return error;
    }

    @ExceptionHandler({ConflictException.class})
    public
    @ResponseBody
    ErrorResponse handleConflict(ConflictException ex) {
        return new ErrorResponse(HttpServletResponse.SC_CONFLICT, "Error", ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public
    @ResponseBody
    ErrorResponse handleBadCredentials(BadCredentialsException ex) {
        return new ErrorResponse(HttpServletResponse.SC_BAD_REQUEST, "Error", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    ErrorResponse handleAllErrors(Exception ex) {
        ErrorResponse error = new ErrorResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error", ex.getMessage());
        return error;
    }
}
