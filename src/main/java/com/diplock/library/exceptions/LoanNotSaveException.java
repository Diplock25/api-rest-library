package com.diplock.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanNotSaveException extends RuntimeException {

  public LoanNotSaveException(String message) {

    super(message);

  }

}
