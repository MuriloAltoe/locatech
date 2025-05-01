package com.locatech.locatech.controllers.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.locatech.locatech.dtos.ResourceNotFoundDTO;
import com.locatech.locatech.dtos.ValidationErrorDTO;
import com.locatech.locatech.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDTO> handlerResourceNotFoundException(
            ResourceNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status.value())
                .body(new ResourceNotFoundDTO(e.getMessage(), status.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorDTO> methodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        var status = HttpStatus.BAD_REQUEST;

        List<String> errors = new ArrayList<String>();
        for(var error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        return ResponseEntity
                .status(status.value())
                .body(new ValidationErrorDTO(errors, status.value()));
    }
}
