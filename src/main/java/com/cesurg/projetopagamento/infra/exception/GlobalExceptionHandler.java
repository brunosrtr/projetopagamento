package com.cesurg.projetopagamento.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        Map<String, Object> body = new HashMap<>();
      body.put("erro", e.getMessage());
      body.put("timestamp", LocalDateTime.now());
      return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

     @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneric(Exception e) {
      Map<String, Object> body = new HashMap<>();
      body.put("erro", "Erro interno no servidor");
      body.put("timestamp", LocalDateTime.now());
      return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
