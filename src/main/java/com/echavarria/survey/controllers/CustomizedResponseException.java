package com.echavarria.survey.controllers;

import com.echavarria.survey.entities.dtos.ErrorResponse;
import com.echavarria.survey.exceptions.EntityAlreadyExistException;
import com.echavarria.survey.exceptions.EntityNotFoundException;
import com.echavarria.survey.exceptions.MissingRequiredDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            EntityNotFoundException.class
    })
    @ResponseBody
    public ErrorResponse notFoundRequest(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                request.getRequestURI(), HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MissingRequiredDataException.class,
            EntityAlreadyExistException.class
    })
    @ResponseBody
    public ErrorResponse badRequest(Exception exception, HttpServletRequest request) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                request.getRequestURI(), HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage());
    }
}
