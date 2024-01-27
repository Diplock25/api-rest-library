package com.diplock.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControlAdvice {

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<Object> categoryNotFoundHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - Category not found")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(LoanNotFoundException.class)
  public ResponseEntity<Object> loanNotFoundHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - Loan not found")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(CategoryNotSaveException.class)
  public ResponseEntity<Object> categoryNotSaveHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - Category can´t be saved")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(LoanNotSaveException.class)
  public ResponseEntity<Object> loanNotSaveHandler(Exception e) {

    ApiError apiError = ApiError.builder()
        .message(e.getMessage())
        .description("(Exception) - Loan can´t be saved")
        .date(java.time.LocalDate.now())
        .build();

    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

  }
  
}
