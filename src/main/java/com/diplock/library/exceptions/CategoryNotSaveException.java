package com.diplock.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryNotSaveException extends RuntimeException {

  public CategoryNotSaveException(String message) {

    super(message);

  }

}
