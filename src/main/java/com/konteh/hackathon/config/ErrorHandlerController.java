package com.konteh.hackathon.config;


import com.konteh.hackathon.exception.ErrorInfo;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandlerController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    public ErrorInfo handleNotFoundException(HttpServletRequest request, NoSuchElementException ex) {
        return new ErrorInfo(request.getRequestURI(), ex.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({PessimisticLockingFailureException.class})
    @ResponseBody
    public ErrorInfo handleConcurrencyFailureException(HttpServletRequest request, ConcurrencyFailureException ex) {
        return new ErrorInfo(request.getRequestURI(), ex.getCause().getMessage(), LocalDateTime.now(), HttpStatus.CONFLICT);
    }
}
