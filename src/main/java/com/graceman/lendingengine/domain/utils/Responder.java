package com.graceman.lendingengine.domain.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service

public class Responder<T> {

    public ResponseEntity<ApiResponse> success(String message, T payload) {
        return new ResponseEntity<>(new ApiResponse(message, true, LocalDateTime.now(), payload), HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> notFound(String message) {
        return new ResponseEntity<>(new ApiResponse(message, true,LocalDateTime.now(), null), HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<ApiResponse> alreadyExisted(String message) {
        return new ResponseEntity<>(new ApiResponse(message, true,LocalDateTime.now(), null), HttpStatus.CONFLICT);
    }
    public ResponseEntity<ApiResponse> error(String message) {
        return new ResponseEntity<>(new ApiResponse(message, true,LocalDateTime.now(), null), HttpStatus.BAD_REQUEST);
    }
}
