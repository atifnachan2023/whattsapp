package com.whattsapp.prototype.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){


        Map<String,String> res=new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)->{

            String fieldName=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            res.put(fieldName,message);
        });


        return new ResponseEntity<Map<String,String>>(res, HttpStatus.BAD_REQUEST);
}


}
