package com.example.postgenerator.controller;

import com.example.postgenerator.domain.ApiResponse;
import com.example.postgenerator.util.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity
                .badRequest()
                .body(ApiResponse.<Void>builder()
                        .success(false)
                        .code(ErrorCode.BAD_REQUEST.name())
                        .message(ex.getMessage())
                        .data(null)
                        .build()
                );
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ApiResponse<Void>> handleUnauthorized(HttpClientErrorException.Unauthorized ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.<Void>builder()
                        .success(false)
                        .code(ErrorCode.UNAUTHORIZED.name())
                        .message(ex.getMessage())
                        .data(null)
                        .build()
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleInternalServerError(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.<Void>builder()
                        .success(false)
                        .code(ErrorCode.INTERNAL_SERVER_ERROR.name())
                        .message("예상치 못한 서버 오류가 발생했습니다.")
                        .data(null)
                        .build()
                );
    }
}
