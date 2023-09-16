package ru.maxizenit.banksystem.userservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<String> handleForbiddenException(Exception e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
  }
}
