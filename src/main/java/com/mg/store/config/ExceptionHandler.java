package com.mg.store.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mg.store.dto.ResponseDto;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ConflictException.class)
    public ResponseEntity<ResponseDto> handleProductNotFound(ConflictException ex) {
        ResponseDto error = new ResponseDto(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
