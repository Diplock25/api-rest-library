package com.diplock.library.services;

import com.diplock.library.entities.Loan;
import java.util.List;
import java.util.Optional;

public interface LoanService {
  List<Loan> findAll();
  Optional<Loan> findById(Long loanid);
  Loan save(Loan loan);
  void update(Loan loan);
  void delete(Long loanid);
}
