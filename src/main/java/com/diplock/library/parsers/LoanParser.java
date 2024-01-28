package com.diplock.library.parsers;

import com.diplock.library.dataholders.LoanDh;
import com.diplock.library.exceptions.LoanNotSaveException;
import java.util.Objects;

public class LoanParser {

  public void Evaluator(LoanDh loanDh) {
    if (Objects.equals(loanDh.getLoanDate(), null)) {
      throw new LoanNotSaveException("POST - Parameters are incorrect for field LoanDate - name is null");
    } else if (loanDh.getLoanDate().isBlank()) {
      throw new LoanNotSaveException("POST - Parameters are incorrect for field LoanDate - name is blank");
    }

    if (Objects.equals(loanDh.getReturnDate(), null)) {
      throw new LoanNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is null");
    } else if (loanDh.getReturnDate().isBlank()) {
      throw new LoanNotSaveException("POST - Parameters are incorrect for field ReturnDate - name is blank");
    }
  }

}
