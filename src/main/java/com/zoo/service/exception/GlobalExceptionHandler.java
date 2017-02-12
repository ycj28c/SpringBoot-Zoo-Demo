package com.zoo.service.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error handler
 * Reference:
 * http://blog.didispace.com/springbootexception/
 * https://segmentfault.com/a/1190000006749441
 */

@ControllerAdvice //global exception handler
public class GlobalExceptionHandler {
	
    @ExceptionHandler(value = ZooAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, ZooAlreadyExistsException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(HttpStatus.CONFLICT.value());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
    
    @ExceptionHandler(value = ZooNullException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, ZooNullException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage());
        r.setCode(HttpStatus.NOT_FOUND.value());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
    
}
