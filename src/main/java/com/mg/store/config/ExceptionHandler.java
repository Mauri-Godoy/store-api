package com.mg.store.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.mg.store.dto.ResponseDto;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(ConflictException.class)
    public ResponseEntity<ResponseDto> handleProductNotFound(ConflictException ex) {
        logger.warn(ex.getMessage());
        ResponseDto error = new ResponseDto(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
